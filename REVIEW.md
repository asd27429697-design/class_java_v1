# 코드 리뷰 — team_project_jdbc (학사관리 시스템)

리뷰 일자: 2026-09-17
리뷰 범위: `src/main/java/com/tenco` 의 dao, dto, service, util, `view/LmsView.java`, `Main.java`, `build.gradle`, `.gitignore`, `README.md`, `src/test`, git 커밋 이력
리뷰 제외: `view/MainFrame.java`, `view/LoginFrame.java` (AI 생성 Swing 코드)

---

## 1. 총평

JDBC를 처음 다루는 단계에서 나올 수 있는 결과물 중에서는 상위권입니다. 특히 세 가지는 이 단계에서 보기 드뭅니다. SQL에 값을 문자열로 이어 붙인 곳이 저장소 전체에 단 한 곳도 없다는 점, 비밀번호를 BCrypt 해시로 저장하고 로그인 결과 객체에 비밀번호를 담지 않는다는 점, 수강신청에 `SELECT ... FOR UPDATE` 로 실제 락을 걸어 동시성을 처리하려 했다는 점입니다.

반면 가장 급한 것은 **수강신청 도메인의 실행 결함 3건**입니다. 수강취소는 어떤 경우에도 성공하지 않고, 관리자의 전체 수강신청 조회는 항상 오류 메시지만 출력합니다. 세 건 모두 DB 문제가 아니라 자바 코드의 기본 문법 문제이며, 수정에 걸리는 시간은 각각 1분 내외입니다. 즉 "설계가 틀렸다"가 아니라 "마지막에 실행해 보지 않았다"에 가깝습니다.

구조적으로 가장 크게 다시 생각해 볼 부분은 트랜잭션 경계가 Service가 아닌 DAO에 있다는 점과, 정원 상태를 `lectures.available` 플래그와 실제 `COUNT(*)` 두 곳에 나눠 저장한 점입니다. 후자는 이미 결과가 나왔습니다. **현재 DB의 강의 6개 중 2개가 자리가 남았는데도 "수강인원초과"로 표시되어 신청이 막혀 있습니다.**

---

## 2. 검증 방법과 한계

### 실제로 실행해서 확인한 것

| 항목 | 방법 | 결과 |
| :--- | :--- | :--- |
| 컴파일 | Gradle 9.6.0 / JDK 21 로 `compileJava`, `compileTestJava` | 통과 (EXIT=0) |
| 단위 테스트 | `src/test` 전체 확인 | **테스트 0건**. 유일한 테스트 파일이 전부 주석 처리되어 있음 |
| `%d` 에 String 인자 | 별도 프로그램으로 재현 | `IllegalFormatConversionException: d != java.lang.String` 발생 확인 |
| String `==` 비교 | 별도 프로그램으로 재현 | 값이 같아도 `==` 는 `false`, `.equals()` 는 `true` 확인 |
| `.gitignore` 의 wrapper jar 제외 | `git check-ignore -v` | `.gitignore:241:*.jar` 규칙에 걸려 제외됨 확인 |
| 커밋 이력 | `git log`, `git show`, `git rev-list` | 아래 6장에 기재 |
| 이력상 평문 비밀번호 | `git log -S'PJ_PASSWORD'` 후 `git show` | 특정 커밋에서 하드코딩 확인 |
| **DB 스키마** | `project_team1` 에 접속해 `SHOW CREATE TABLE`, `information_schema` 조회 | 4개 테이블 전체 확인. 부록 A에 기재 |
| **DB 실제 데이터** | 조회(SELECT) 쿼리 12건 실행 | MJ-2, MJ-3, MJ-6, MJ-8, MN-5, MN-7, MN-8 확정 |

DB 검증은 **조회 쿼리만** 사용했으며 데이터를 변경하지 않았습니다. 확인 시점의 규모는 회원 15명(관리자 3명), 강의 6개, 수강신청 13건, 성적 10건입니다.

### DB 검증으로 바로잡은 내용

검증 전 추론으로 작성했다가 실제 확인 후 정정한 항목입니다. 어느 쪽이 맞는지 기억해 두면 좋습니다.

| 항목 | 검증 전 추론 | 실제 확인 결과 |
| :--- | :--- | :--- |
| MJ-2 | 점수 NULL 행이 평균 성적을 왜곡한다 | **틀림**. SQL의 `AVG()` 는 NULL을 계산에서 제외한다. 실제 증상은 다른 형태로 나타난다 |
| MN-5 | 13번 이후 회원은 비밀번호가 평문으로 남는다 | **틀림**. 현재 회원 15명 전원이 BCrypt 해시 상태다 |
| MN-7 | 로그인의 `memberId.equals(...)` 는 의미 없는 중복 검사다 | **틀림**. 이 검사가 대소문자를 구분하는 유일한 장치다 |

### 여전히 확인하지 못한 것

- 저장소가 GitHub에 공개(public)로 설정되어 있는지 (MJ-11 의 위험 범위를 결정합니다) — **확인 필요**
- `MembersDAO.login` 의 대소문자 검사가 의도된 것인지 우연인지 (MN-7) — **확인 필요**. 코드에 주석이 없어 작성자 확인이 필요합니다

---

## 3. 잘된 부분

### 3-1. SQL 인젝션 방어가 예외 없이 지켜졌습니다

DAO 4개 전체에서 값을 SQL 문자열에 이어 붙인 곳이 한 곳도 없습니다. 검색처럼 이어 붙이기 쉬운 자리에서도 `%` 만 값에 붙여 파라미터로 넘겼습니다.

```java
// LecturesDAO.java:56-58
pstmt.setString(1, "%" + keyword + "%");
pstmt.setString(2, "%" + keyword + "%");
pstmt.setString(3, "%" + keyword + "%");
```

**왜 잘한 것인가**: 초보 단계에서 가장 흔한 사고가 `"... WHERE name = '" + input + "'"` 입니다. 이 경우 사용자가 `' OR '1'='1` 을 입력하면 조건이 무력화되고, `'; DROP TABLE members; --` 을 입력하면 테이블이 사라집니다. `?` 파라미터 바인딩은 입력값을 SQL 문법이 아니라 **값**으로만 취급하므로 이런 공격 자체가 성립하지 않습니다. 검색 기능처럼 규칙이 복잡한 자리에서도 이 원칙을 지킨 것은 팀 전체가 이유를 이해하고 있다는 뜻입니다.

### 3-2. 비밀번호를 해시로 저장하고, 로그인 결과에 담지 않았습니다

```java
// MembersDAO.java:22-29
if (rs.next() && memberId.equals(rs.getString("member_id"))
        && BCrypt.checkpw(password, rs.getString("password"))) {
    // 로그인 상태에는 비밀번호를 보관하지 않는다.
    return Members.builder()
            .id(rs.getInt("id"))
            .memberId(rs.getString("member_id"))
            .name(rs.getString("name"))
            .admin(rs.getInt("admin") == 1)
            .build();
}
```

**왜 잘한 것인가**: 두 가지를 동시에 했습니다. 첫째, 비밀번호를 평문으로 비교하지 않고 `BCrypt.checkpw` 로 해시 검증했습니다. BCrypt는 같은 비밀번호라도 매번 다른 해시를 만들기 때문에(솔트) DB가 유출되어도 원문을 복구하기 어렵습니다. 둘째, 로그인 성공 객체에 `password` 를 넣지 않았습니다. 세션 객체에 비밀번호가 남아 있으면 로그 출력이나 `toString()` 한 번으로 그대로 노출됩니다. 주석으로 의도까지 남긴 점이 좋습니다.

### 3-3. 수강신청에 비관적 락을 걸었습니다

```java
// RegistrationDAO.java:25-27
String chkSql = """
        SELECT available, capacity FROM lectures WHERE id = ? FOR UPDATE
        """;
```

**왜 잘한 것인가**: 정원 30명인 강의에 두 사람이 동시에 신청하면, 둘 다 "현재 29명"을 읽고 둘 다 INSERT 해서 31명이 되는 문제가 생깁니다. `FOR UPDATE` 는 해당 행에 락을 걸어 뒤에 온 트랜잭션을 커밋될 때까지 대기시킵니다. 그 결과 인원 확인과 INSERT가 한 사람씩 순서대로 처리됩니다. 락을 건 **뒤에** 다시 COUNT 한 순서까지 맞습니다. 이 문제를 인식했다는 것 자체가 교육과정 수준에서는 드뭅니다. 커밋 이력에도 `동시성문제수정` 이 남아 있어, 실제로 문제를 발견하고 고쳤다는 것을 알 수 있습니다.

### 3-4. `getInt` 의 NULL 함정을 알고 피했습니다

```java
// MembersDAO.java:70
.score(rs.getObject("score") == null ? null : rs.getInt("score"))
```

**왜 잘한 것인가**: `ResultSet.getInt()` 는 컬럼 값이 NULL이면 예외를 던지지 않고 **0을 반환합니다**. 성적이 없는 학생과 평균 0점인 학생이 화면에서 구분되지 않게 되는 것입니다. `getObject` 로 NULL을 먼저 판별하고 DTO 필드를 `Integer` 로 둔 뒤, 화면에서 "미등록"으로 출력한 처리(`LmsView.java:499`)까지 일관됩니다. 문서를 읽지 않으면 알기 어려운 함정입니다.

### 3-5. 조회 SQL을 JOIN으로 한 번에 해결했습니다

```sql
-- MembersDAO.java:42-54
select m.id, m.member_id, m.name, m.phone, m.major, m.grade,
       round(avg(s.score)) as score
from members m
left join scores s on m.id = s.member_id
where m.id = ?
group by m.id, m.member_id, m.name, m.phone, m.major, m.grade
```

**왜 잘한 것인가**: 회원을 조회하고, 그 회원의 성적을 다시 조회해서 자바에서 평균을 내는 방식(N+1 조회)을 피했습니다. `LEFT JOIN` 을 쓴 것도 정확합니다. `INNER JOIN` 이었다면 성적이 아직 없는 학생은 조회 결과에서 아예 사라집니다.

### 3-6. ResultSet 매핑을 메서드로 추출했습니다

`LecturesDAO.createLectures()`, `ScoreDAO.createScore()` 처럼 `ResultSet` → DTO 변환을 별도 메서드로 뺐습니다. 컬럼이 하나 추가될 때 고칠 곳이 한 곳뿐입니다. 같은 파일 안에서 조회 메서드가 4개인데 매핑 코드가 4벌 복사되어 있었다면 컬럼 추가 때마다 한 곳씩 빠뜨리게 됩니다.

### 3-7. 화면 입력 검증을 재사용 가능한 단위로 분리했습니다

`LmsView` 의 `readInt`, `readPositiveInt`, `readOptionalPositiveInt`, `readRequiredText`, `readAvailable` 은 각각 하나의 입력 규칙만 담당하고 잘못된 값이면 다시 묻습니다. 삭제와 취소 전에 "예 / 아니오" 확인을 받는 절차도 일관되게 들어가 있습니다. 콘솔 프로그램에서 `Integer.parseInt` 를 곳곳에 흩어 놓아 `NumberFormatException` 으로 죽는 것이 흔한 패턴인데, 그 문제가 없습니다.

---

## 4. 지적 사항

심각도 기준입니다.

- **Blocker** : 실행하면 터지거나 데이터가 깨진다. 반드시 고쳐야 함
- **Major** : 지금은 동작하지만 조건이 바뀌면 깨진다. 고쳐야 함
- **Minor** : 동작에는 문제없으나 유지보수에 불리하다. 고치면 좋음
- **Nit** : 취향에 가까운 사소한 것. 참고만

---

### [Blocker] BL-1. 수강취소가 어떤 입력으로도 성공하지 않습니다

**위치**: `src/main/java/com/tenco/view/LmsView.java:189`

```java
for (Registration registration : registrations) {
    if (registration.getMemberId() == memberId && registration.getLectureId() == lectureId) {
```

**무엇이 문제인가**

`registration.getMemberId()` 와 `memberId` 는 둘 다 `String` 입니다. 자바에서 `==` 는 문자열의 **내용**이 아니라 **같은 객체인지**를 비교합니다. `memberId` 는 로그인할 때 `ResultSet` 이 만든 객체이고, `registration.getMemberId()` 는 수강신청 조회 때 `ResultSet` 이 새로 만든 객체입니다. 글자가 같아도 서로 다른 객체이므로 `==` 는 항상 `false` 입니다.

**어떤 상황에서 터지는가** (재현 확인)

학번 `20260001` 로 로그인 → 수강신청 관련 메뉴 → 4번 내 수강취소 → 신청 내역이 정상 출력됨 → 강의번호 입력 → **"본인이 신청한 강의번호만 취소할 수 있습니다."**

자기 강의를 정확히 입력해도 같은 결과입니다. 즉 수강취소 기능은 한 번도 성공한 적이 없습니다.

별도 프로그램으로 확인한 결과입니다.

```
a == b : false / a.equals(b) : true
```

**수정안**

```java
if (memberId.equals(registration.getMemberId()) && registration.getLectureId() == lectureId) {
```

`memberId` 를 앞에 두는 이유는 `memberId` 가 로그인 상태에서 온 값이라 null이 아님이 보장되기 때문입니다. 반대로 쓰면 DB 값이 null일 때 `NullPointerException` 이 납니다.

**왜 그렇게 고치는가**

문자열 비교는 예외 없이 `.equals()` 입니다. `==` 가 우연히 맞는 것처럼 보이는 경우가 있는데, 소스에 직접 쓴 `"abc"` 같은 리터럴은 자바가 같은 객체를 재사용하기 때문입니다. DB나 키보드에서 읽은 값은 매번 새 객체라 절대 맞지 않습니다. **"테스트할 때는 됐는데 실제로는 안 된다"** 의 전형적인 원인이 이것입니다.

---

### [Blocker] BL-2. 수강신청과 수강취소가 서로 다른 식별자를 넘깁니다

**위치**: `src/main/java/com/tenco/view/LmsView.java:170` 과 `:195-196`

```java
// 신청 — members.id (PK, 숫자) 를 넘김
registrationService.applyLecture(
        String.valueOf(loggedInMember.getId()), String.valueOf(lecture.getId()));

// 취소 — member_id (학번 문자열) 를 넘김
registrationService.deleteRegistration(
        String.valueOf(memberId), String.valueOf(lectureId));
```

**무엇이 문제인가**

`cancelRegistration` 의 `memberId` 는 `loggedInMember.getMemberId()`, 즉 **학번 문자열**(`"20260001"`)입니다. 반면 `registration.member_id` 컬럼은 `members.id` (PK, 숫자)를 참조하는 외래키입니다. 신청은 PK를, 취소는 학번을 넘기고 있어 같은 테이블을 서로 다른 기준으로 다루고 있습니다.

참고로 `String.valueOf(memberId)` 는 `memberId` 가 이미 String이므로 아무 일도 하지 않습니다. 이 코드 자체가 "여기에 숫자가 와야 한다고 생각했는데 실제로는 문자열이 오고 있다"는 신호입니다.

**어떤 상황에서 터지는가**

BL-1 을 고친 뒤에 드러나는 두 번째 실패입니다. `RegistrationDAO.deleteRegistration:140` 의 첫 검사가 `where member_id = '20260001'` 으로 실행됩니다. `registration.member_id` 는 INT이므로 MySQL이 문자열을 숫자로 변환해 비교하는데, PK는 1~18 범위라 20260001과 매칭되는 행이 없습니다. 결과는 `SQLException("본인으로 신청된 강의가 없습니다 ID : 20260001")` → 화면에는 "수강 취소 실패" 만 출력됩니다.

학번이 숫자가 아닌 학생은 더 조용히 실패합니다. 현재 회원 중 `student05`, `admin01`, `test1` 같은 학번이 있는데, MySQL은 이런 문자열을 INT와 비교할 때 오류 없이 **0으로 변환**합니다.

```sql
SELECT 'student05' + 0, '20260001' + 0;
-- 0, 20260001
```

**오삭제 위험에 대하여**: 학번이 `"3"` 처럼 현재 PK 범위(1~18)의 숫자라면 `member_id = '3'` 이 **PK가 3인 다른 학생**의 행과 매칭되어 남의 수강신청이 삭제될 수 있습니다. 현재 회원 15명의 학번을 확인한 결과 그런 값은 없어 **지금 당장의 위험은 없습니다.** 다만 학번 체계가 바뀌거나 테스트 계정이 추가되는 순간 성립하는 위험이므로, 우연히 안전한 상태로 두지 말고 고쳐야 합니다.

**수정안**

```java
registrationService.deleteRegistration(
        String.valueOf(loggedInMember.getId()), String.valueOf(lectureId));
```

근본 수정은 MJ-8과 함께 파라미터 타입을 `int` 로 바꾸는 것입니다.

```java
// RegistrationDAO
public void registerLecture(int memberId, int lectureId) { ... }
public void deleteRegistration(int memberId, int lectureId) { ... }
```

**왜 그렇게 고치는가**

`String memId` 라는 이름은 학번인지 PK인지 알려주지 않습니다. 이름이 모호하면 부르는 쪽마다 다르게 해석하고, 지금처럼 신청과 취소가 갈립니다. 타입을 `int` 로 바꾸면 학번 문자열을 실수로 넘기는 순간 **컴파일이 실패**합니다. 실행 중에 조용히 틀리는 것보다 컴파일에서 막히는 편이 언제나 낫습니다.

---

### [Blocker] BL-3. 관리자의 전체 수강신청 조회가 항상 오류로 끝납니다

**위치**: `src/main/java/com/tenco/view/LmsView.java:212-213`

```java
System.out.printf("회원번호: %d | 학생: %s | ",
        registration.getMemberId(), registration.getMemberName());
```

**무엇이 문제인가**

`%d` 는 정수 자리 표시자인데 `registration.getMemberId()` 의 타입은 `String` 입니다 (`Registration.java:11`). `printf` 는 타입이 맞지 않으면 예외를 던집니다.

**어떤 상황에서 터지는가** (재현 확인)

관리자 로그인 → 4번 수강신청 관련 메뉴 → 2번 전체 수강신청 조회

```
=== 수강신청 내역 ===
오류: d != java.lang.String
```

실행으로 확인한 예외입니다.

```
java.util.IllegalFormatConversionException / d != java.lang.String
```

`registrationsMenu` 의 `catch (RuntimeException e)` 가 잡아서 프로그램이 죽지는 않지만, 관리자 기능 하나가 통째로 동작하지 않습니다. 한 건이라도 조회되면 무조건 실패합니다.

**수정안**

```java
System.out.printf("회원번호: %s | 학생: %s | ",
        registration.getMemberId(), registration.getMemberName());
```

**왜 그렇게 고치는가**

`printf` 의 타입 불일치는 컴파일러가 잡아주지 않고 실행 시점에야 터집니다. 이런 코드는 **해당 화면을 한 번이라도 실행해 보면 즉시 드러납니다**. 세 Blocker 모두 같은 성격입니다. 코드를 다 쓴 뒤 각 메뉴를 한 번씩 눌러 보는 절차가 있었다면 전부 걸렸을 것입니다. 기능 완성의 기준을 "컴파일이 된다"가 아니라 "메뉴를 눌러서 결과를 봤다"로 잡아야 합니다.

---

### [Major] MJ-1. 전체 수강신청 조회 결과에 강의코드가 없어 null이 출력됩니다

**위치**: `src/main/java/com/tenco/dao/RegistrationDAO.java:267` / `view/LmsView.java:216`

```sql
select r.id, r.member_id, m.name, r.lecture_id, l.lecture_name
from registration r
...
```

```java
System.out.printf("강의코드: %s | 강의명: %s%n",
        registration.getLectureCode(), registration.getLectureName());
```

**무엇이 문제인가**

`getAllRegistrations` 의 SELECT 목록에 `l.lecture_code` 가 없습니다. DTO의 `lectureCode` 는 채워지지 않아 `null` 로 남습니다. 반면 화면은 항상 강의코드를 출력합니다.

**어떤 상황에서 터지는가**

BL-3 을 고친 직후 드러납니다.

```
회원번호: 3 | 학생: (학생명) | 강의코드: null | 강의명: (강의명)
```

`getMyRegistrations` 는 `l.lecture_code` 를 포함하므로 학생 화면에서는 정상입니다. 같은 DTO를 두 SQL이 서로 다른 범위로 채우고 있는 것이 원인입니다.

**수정안**

```sql
select r.id, r.member_id, m.name, r.lecture_id, l.lecture_code, l.lecture_name
from registration r
join members m on r.member_id = m.id
join lectures l on r.lecture_id = l.id
order by r.member_id
```

**왜 그렇게 고치는가**

같은 DTO를 쓰는 두 조회는 채우는 필드 범위를 맞추거나, 아예 화면별로 다른 DTO를 쓰는 편이 낫습니다. 지금 구조에서는 "이 조회는 어떤 필드가 채워져 있는가"를 SQL을 열어봐야만 알 수 있고, 필드가 하나 늘 때마다 같은 실수가 반복됩니다.

---

### [Major] MJ-2. 성적 추가가 점수 없이 INSERT 해서 같은 학생이 화면마다 다르게 보입니다

**위치**: `src/main/java/com/tenco/dao/ScoreDAO.java:140-144`

```java
String insertSql = """
        insert into scores(member_id, lecture_id)
        values (?, ?)
        """;
```

**무엇이 문제인가**

`scores.score` 컬럼에 값을 주지 않습니다. 화면 흐름(`LmsView.addScore`)은 "성적 항목을 먼저 만들고 수정 메뉴에서 점수를 채운다"는 2단계 설계인데, DB 입장에서는 **점수가 비어 있는 성적 행**이 남습니다.

**어떤 상황에서 터지는가** (DB 확인 완료)

스키마를 확인한 결과 `score` 는 `int DEFAULT NULL`, 즉 NULL 허용입니다. 따라서 INSERT는 실패하지 않고 **점수가 비어 있는 행이 조용히 생깁니다.** 실제로 성적 10건 중 1건이 이미 이 상태입니다.

```
member_id  rows_cnt  non_null  AVG(score)
10         1         0         NULL
```

이 학생(PK 10)에게 두 화면이 서로 다른 말을 합니다.

- **성적 조회 화면**: `ScoreDAO.createScore` 의 `rs.getInt("score")` 가 NULL을 **0으로** 바꿔 돌려주므로 → `점수: 0` 으로 표시됩니다
- **학생 정보 화면**: `MembersDAO` 의 `round(avg(s.score))` 결과가 NULL이므로 (아래 설명) → `평균 점수: 미등록` 으로 표시됩니다

같은 학생이 한 화면에서는 0점을 받은 사람이고 다른 화면에서는 성적이 없는 사람입니다. 오류 메시지가 전혀 나오지 않으므로 아무도 눈치채지 못합니다.

> **짚고 넘어갈 점**: SQL의 `AVG()` 는 NULL을 **계산 대상에서 제외**합니다. 3건 중 1건이 NULL이면 나머지 2건의 평균이 나오고, 전부 NULL이면 결과도 NULL입니다. 0으로 치지 않습니다. 따라서 평균 자체는 왜곡되지 않습니다. 왜곡되는 것은 **자바의 `rs.getInt()` 를 거친 개별 점수 표시**입니다. SQL 집계 함수와 JDBC의 NULL 처리 방식이 다르다는 점이 이 결함의 핵심입니다.

3-4 에서 `getObject` 로 NULL을 정확히 구분했던 것과 대조적으로, 성적 조회 쪽에서는 같은 함정에 그대로 걸렸습니다.

**수정안**

점수를 함께 받는 것이 가장 단순합니다.

```java
// ScoreService
public void addScore(String memberId, String lectureCode, Integer score) throws SQLException {
    if (score == null || score < 0 || score > 100) {
        throw new IllegalArgumentException("성적은 0~100 사이여야 합니다.");
    }
    ...
}
```

```sql
insert into scores(member_id, lecture_id, score) values (?, ?, ?)
```

2단계 설계("항목 먼저 만들고 점수는 나중에")를 유지한다면, `scores.score` 가 이미 NULL 허용이므로 **조회 쪽만** 3-4 와 같은 방식으로 바꾸면 됩니다.

```java
// Scores DTO 의 score 를 int → Integer 로 바꾸고
.score(rs.getObject("score") == null ? null : rs.getInt("score"))

// 화면에서 구분해 출력
System.out.printf("학생: %s | 과목: %s | 점수: %s%n",
        score.getName(), score.getLectureName(),
        score.getScore() == null ? "미입력" : score.getScore());
```

같은 저장소의 `MembersDAO:70` 과 `LmsView:499` 가 이미 이 방식입니다. 그대로 따라 쓰면 됩니다.

**왜 그렇게 고치는가**

"값이 없다"와 "값이 0이다"는 다른 상태입니다. DB가 이를 NULL과 0으로 구분해 주는데 자바 코드가 `int` 로 받아 뭉개면 구분이 사라집니다. 같은 저장소 안에 올바른 예(`MembersDAO:70`)가 이미 있으므로, 팀 규칙으로 통일하기 좋은 지점입니다.

---

### [Major] MJ-3. 정원 상태를 두 곳에 나눠 저장해 어긋날 수 있습니다

**위치**: `dao/RegistrationDAO.java:53-62, 90-100, 176-192` / `service/LecturesService.java:67`

**무엇이 문제인가**

"이 강의를 신청할 수 있는가"의 진짜 근거는 `COUNT(registration) < lectures.capacity` 입니다. 그런데 이 결론을 `lectures.available` 컬럼에도 저장하고 있습니다. 계산으로 얻을 수 있는 값을 따로 저장하는 것을 **파생 데이터 중복**이라고 하며, 두 값이 어긋나는 순간부터 어느 쪽이 맞는지 알 수 없게 됩니다.

지금 코드에는 이미 어긋나는 경로가 세 개 있습니다.

1. **관리자가 직접 뒤집을 수 있음** — `LecturesService.java:67` 의 `exLecture.setAvailable(newLecture.isAvailable())` 은 정원과 무관하게 값을 덮어씁니다. 정원이 꽉 찬 강의를 관리자가 "가능"으로 바꾸면 초과 신청이 가능해집니다.
2. **정원만 바꿔도 갱신되지 않음** — 강의 수정 메뉴에서 `capacity` 만 조정하면 `available` 은 그대로입니다. 정원을 30에서 20으로 줄여도 `true` 로 남고, 반대로 2에서 11로 늘려도 `false` 로 남습니다.
3. **DB에서 직접 손댈 때** — `registration` 행을 SQL로 지우면 `available` 은 `false` 로 남습니다. 화면을 거치지 않는 모든 변경이 여기 해당합니다.

**이미 터져 있습니다** (DB 확인 완료)

가정이 아닙니다. 현재 DB의 강의 6개 중 **2개가 이미 어긋나 있습니다.**

```sql
SELECT l.id, l.lecture_code, l.capacity, COUNT(r.id) AS enrolled, l.available
FROM lectures l LEFT JOIN registration r ON r.lecture_id = l.id
GROUP BY l.id, l.lecture_code, l.capacity, l.available;
```

| id | 강의코드 | 정원 | 실제 신청 | available | 상태 |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | CS101 | 11 | 2 | 0 | **불일치** — 9자리가 비었는데 신청 불가 |
| 6 | TE102 | 2 | 1 | 0 | **불일치** — 1자리가 비었는데 신청 불가 |
| 2 | CS102 | 4 | 2 | 1 | 정상 |
| 3 | EE201 | 3 | 2 | 1 | 정상 |
| 4 | ME301 | 4 | 4 | 0 | 정상 |
| 5 | BM101 | 2 | 2 | 0 | 정상 |

CS101 은 정원이 11인데 2명만 신청되어 있습니다. 정원이 작았을 때 `available` 이 `false` 로 바뀌었고, 그 뒤 정원만 11로 늘린 것으로 보입니다(위 경로 2). TE102 도 같은 형태입니다.

학생이 CS101 을 신청하려 하면 강의 목록에 **"수강인원초과"** 로 표시되고, `LmsView:165` 의 `if (!lecture.isAvailable())` 에 걸려 신청 자체가 막힙니다. 자리가 9개 남아 있는데도 아무도 신청할 수 없습니다.

한 번 `false` 가 된 강의는 **수강취소로만 `true` 로 돌아옵니다.** 그런데 그 수강취소가 BL-1/BL-2 로 동작하지 않습니다. 즉 현재 시스템에는 이 상태를 정상으로 되돌릴 방법이 화면상에 없습니다. 관리자가 강의 수정 메뉴에서 상태를 직접 "가능"으로 바꾸는 것이 유일한 방법인데, 그 경로 자체가 이 결함의 원인이기도 합니다.

반대 방향도 성립합니다. 정원이 꽉 찬 강의를 관리자가 "가능"으로 바꾸면 → 학생이 신청 → `RegistrationDAO` 의 COUNT 검사에 걸려 실패 → 그때서야 `false` 로 복구됩니다. 학생이 실패를 한 번 겪어야 상태가 맞춰지는 구조입니다.

**수정안**

가장 안전한 방향은 `available` 을 **저장하지 않고 조회할 때 계산**하는 것입니다.

```sql
select l.*,
       (select count(*) from registration r where r.lecture_id = l.id) as enrolled,
       (l.capacity > (select count(*) from registration r where r.lecture_id = l.id)) as available
from lectures l
order by l.id
```

컬럼을 유지해야 한다면, 최소한 관리자 수정 화면에서 `available` 을 직접 입력받지 않도록 막아야 합니다.

```java
// LecturesService.updateLectures — available 은 정원 기준으로만 바뀌게 둔다
// exLecture.setAvailable(newLecture.isAvailable());  // 제거
```

**왜 그렇게 고치는가**

같은 사실을 두 곳에 저장하면, 한 곳만 바꾸는 코드가 반드시 생깁니다. 지금 세 경로가 이미 그렇습니다. "휴강 여부" 처럼 정원과 무관한 별도 의미를 담을 컬럼이 필요하다면 이름을 `is_closed` 등으로 분리하고, 정원 판정은 COUNT로만 하는 편이 낫습니다.

---

### [Major] MJ-4. 트랜잭션 경계가 DAO 안에 있습니다

**위치**: `dao/RegistrationDAO.java:18, 129` / `dao/ScoreDAO.java:116`

```java
// RegistrationDAO.registerLecture
conn = DatabaseUtil.getConnection();
conn.setAutoCommit(false);
...
conn.commit();
```

**무엇이 문제인가**

트랜잭션(여러 SQL을 "전부 성공 아니면 전부 취소"로 묶는 단위)의 시작과 끝이 DAO 메서드 안에 갇혀 있습니다. DAO는 자기 커넥션을 스스로 열고 스스로 닫습니다. 그래서 **두 개의 DAO를 하나의 트랜잭션으로 묶을 방법이 없습니다.**

**어떤 상황에서 터지는가**

지금은 각 기능이 DAO 하나로 끝나서 문제가 드러나지 않습니다. 다음 요구사항이 들어오는 순간 깨집니다.

- "수강 취소하면 해당 과목 성적도 함께 삭제한다" → `RegistrationDAO.deleteRegistration` 과 `ScoreDAO.deleteScore` 를 묶어야 하는데, 각자 다른 커넥션을 쓰므로 앞쪽만 커밋되고 뒤쪽이 실패하는 상태가 생깁니다.
- 실제로 `ScoreService.addScore` 는 `membersDAO` 조회 → `lecturesDAO` 조회 → `scoreDAO.addScore` 로 커넥션을 **세 번** 열고 닫습니다. 조회 사이에 다른 사람이 강의를 삭제하면 존재하지 않는 강의에 성적을 넣으려 시도하게 됩니다.

**수정안**

Service가 커넥션을 열고 DAO에 넘겨주는 형태로 바꿉니다.

```java
// Service — 트랜잭션 경계는 여기
public void cancelRegistrationWithScore(int memberId, int lectureId) throws SQLException {
    try (Connection conn = DatabaseUtil.getConnection()) {
        conn.setAutoCommit(false);
        try {
            registrationDAO.delete(conn, memberId, lectureId);
            scoreDAO.delete(conn, memberId, lectureId);
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }
}

// DAO — 커넥션을 받아서 쓰기만 한다. 열지도 닫지도 커밋하지도 않는다
public void delete(Connection conn, int memberId, int lectureId) throws SQLException { ... }
```

**왜 그렇게 고치는가**

"이 작업이 하나의 단위인가"는 업무 규칙이고, 업무 규칙은 Service의 책임입니다. DAO는 SQL 한 덩어리를 실행하는 역할이어야 커넥션을 자유롭게 조합할 수 있습니다. 이 구조는 나중에 프레임워크의 트랜잭션 기능을 배울 때 그대로 이어집니다. 지금 당장 전부 바꿀 필요는 없지만, **왜 DAO가 커밋하면 안 되는지**는 팀이 공유해 두어야 합니다.

---

### [Major] MJ-5. 커밋한 뒤에 예외를 던져 롤백이 무의미해집니다

**위치**: `src/main/java/com/tenco/dao/RegistrationDAO.java:53-62`

```java
if (currentCount >= capacity) {
    String updateFullSql = "UPDATE lectures SET available = false WHERE id = ?";
    ...
    conn.commit(); // 상태 변경 반영
    throw new SQLException("정원이 초과되어 수강신청할 수 없습니다.");
}
```

**무엇이 문제인가**

`commit()` 을 먼저 실행하고 예외를 던집니다. 예외는 아래쪽 `catch` 로 가서 `conn.rollback()` 을 호출하지만, 이미 커밋된 트랜잭션은 되돌릴 것이 없습니다. `rollback()` 은 아무 일도 하지 않고 끝납니다.

**어떤 상황에서 터지는가**

지금은 이 자리에서 바꾸는 것이 `available` 플래그 하나뿐이고 그 변경은 남기는 게 맞아서 결과적으로 동작합니다. 하지만 "정원 초과 시 대기 명단에 넣는다" 같은 처리가 이 블록 위쪽에 추가되는 순간, 그 처리까지 함께 커밋된 뒤 예외가 나가서 **부분 커밋**이 됩니다. 롤백된 줄 알았던 데이터가 남는, 추적하기 매우 어려운 버그입니다.

**수정안**

트랜잭션을 정상 종료한 뒤 호출자에게 결과로 알립니다.

```java
if (currentCount >= capacity) {
    try (PreparedStatement updatePstmt = conn.prepareStatement(updateFullSql)) {
        updatePstmt.setInt(1, lectureId);
        updatePstmt.executeUpdate();
    }
    conn.commit();
    return RegisterResult.FULL;   // 예외 대신 결과값으로 전달
}
```

**왜 그렇게 고치는가**

"정원이 찼다"는 **예상 가능한 정상 결과**이지 시스템 오류가 아닙니다. 예상 가능한 결과는 반환값으로, 예상 못 한 실패는 예외로 구분하는 것이 원칙입니다. 그렇게 나누면 `commit` 과 `throw` 가 한자리에 섞이는 상황 자체가 생기지 않습니다.

---

### [Major] MJ-6. 예외를 삼키고 "결과 없음"처럼 반환합니다

**위치 (2곳)**

```java
// LecturesDAO.java:145-148
} catch (SQLException e) {
    // TODO - 추후 토의 후 수정
    System.out.println("데이터베이스 제약 조건으로 인해 삭제할 수 없습니다. (수강 중인 학생이 있을 수 있습니다.)");
}
return rows;   // rows 는 0

// RegistrationDAO.java:293-295
} catch (SQLException e) {
    System.err.println("조회 실패 : " + e);
}
return registrationList;   // 빈 리스트
```

**무엇이 문제인가**

예외를 잡아서 화면에 찍고 정상 반환합니다. 호출한 쪽은 "실패"와 "원래 결과가 없음"을 구분할 수 없습니다.

**어떤 상황에서 터지는가** (DB 확인 완료)

FK 제약을 확인한 결과 `registration`, `scores` 의 외래키는 모두 `DELETE_RULE = NO ACTION` 입니다. 즉 **참조 중인 강의나 회원은 삭제되지 않고 오류가 납니다.** 현재 6개 강의 전부에 수강신청이 걸려 있으므로, 지금 어떤 강의를 삭제하려 해도 반드시 이 경로를 탑니다.

- 강의 삭제: FK 제약으로 실패해도 `rows = 0` 이 반환되고, `LecturesService.deleteLectures` 는 `result > 0` 이 거짓이므로 화면에 "강의를 삭제하지 못했습니다" 만 출력합니다. 진짜 원인인 "수강생이 있어서" 메시지는 DAO가 이미 출력해 버린 뒤라 순서가 뒤엉킵니다. 게다가 이 `catch` 는 **모든** SQLException을 FK 위반으로 단정합니다. DB 연결이 끊긴 경우에도 "수강 중인 학생이 있을 수 있습니다" 가 출력됩니다.
- 회원 삭제도 같은 상황이지만 이쪽은 `MembersDAO.deleteMember` 가 `RuntimeException` 으로 올려보내므로, 화면에 DB 원문 메시지가 그대로 노출됩니다. 같은 성격의 실패를 두 도메인이 정반대로 처리하고 있습니다.
- 전체 수강신청 조회: DB가 죽어도 빈 리스트가 반환되고 화면에는 "수강신청 내역이 없습니다" 가 나옵니다. **장애가 정상처럼 보입니다.**

**수정안**

```java
// LecturesDAO.deleteLectures — 원인을 구분해서 올린다
} catch (SQLIntegrityConstraintViolationException e) {
    throw new IllegalStateException("수강 중인 학생이 있어 삭제할 수 없습니다.", e);
} catch (SQLException e) {
    throw new RuntimeException("강의 삭제 중 DB 오류", e);
}
```

**왜 그렇게 고치는가**

예외를 잡는 목적은 "여기서 처리할 수 있을 때"뿐입니다. DAO는 화면을 모르므로 사용자에게 무엇을 보여줄지 정할 수 없습니다. 판단할 수 없으면 올려보내고, 화면을 아는 계층이 메시지를 정하게 해야 합니다. 이 두 곳은 **장애를 조용히 감추는** 형태라 실무에서 가장 위험한 축에 듭니다.

---

### [Major] MJ-7. 사용자 입력 오류에 SQLException을 사용합니다

**위치**: Service 계층 전반 — `MemberService` 18곳, `ScoreService` 11곳, `LecturesService` 2곳

```java
// LecturesService.java:23
throw new SQLException("검색어를 입력해 주세요");

// MemberService.java:72
throw new SQLException("로그인 후 이용 가능합니다.");

// ScoreService.java:46
throw new SQLException("성적을 제대로 입력해주세요");
```

**무엇이 문제인가**

`SQLException` 은 "DB가 이 작업을 거절했다"는 뜻입니다. "검색어를 입력해 주세요" 는 DB에 가 보지도 않은 단계의 입력 검증 결과입니다. 이름이 사실과 다릅니다.

**어떤 상황에서 터지는가**

당장 프로그램이 죽지는 않지만 두 가지가 무너집니다.

1. **구분 불가** — `LmsView` 의 `catch (RuntimeException | SQLException e)` 가 "검색어를 입력하세요" 와 "DB 연결 실패" 를 똑같이 처리합니다. 전자는 사용자가 다시 입력하면 되고 후자는 관리자를 불러야 하는데, 화면에서는 둘 다 "오류: ..." 로만 보입니다.
2. **전파** — `SQLException` 은 checked exception이라 이를 호출하는 모든 메서드가 `throws SQLException` 을 달아야 합니다. 실제로 `LmsView` 의 메서드 대부분이 `throws SQLException` 을 달고 있고, `Main.main` 까지 올라가 있습니다. DB와 무관한 화면 코드에까지 DB 예외가 번진 것입니다.

**수정안**

```java
// 입력 검증 실패
if (keyword == null || keyword.trim().isEmpty()) {
    throw new IllegalArgumentException("검색어를 입력해 주세요");
}

// 업무 규칙 위반 — 직접 만드는 편이 더 명확하다
public class LmsException extends RuntimeException {
    public LmsException(String message) { super(message); }
}
```

**왜 그렇게 고치는가**

예외 타입은 **"누가 잘못했는가"** 를 알려주는 정보입니다. `IllegalArgumentException` 은 부른 쪽의 입력이 틀렸다는 뜻이고, `SQLException` 은 DB가 거절했다는 뜻입니다. 타입을 사실대로 붙이면 화면 코드가 `catch` 만 보고 "다시 입력받기" 와 "관리자 호출" 을 나눌 수 있습니다. 덤으로 `throws SQLException` 선언이 화면 계층에서 사라집니다.

한편 `MemberService.login` (`:225`)은 이미 `IllegalArgumentException` 을 쓰고 있습니다. 같은 저장소 안에서 두 방식이 공존하므로, 어느 쪽으로 통일할지 정하는 것으로 충분합니다.

---

### [Major] MJ-8. 숫자 컬럼에 문자열을 바인딩합니다

**위치**: `dao/RegistrationDAO.java` 전반 — `setString(1, lecId)`, `setString(1, memId)` 등 8곳

```java
public void registerLecture(String memId, String lecId) throws SQLException {
    ...
    checkPstmt.setString(1, lecId);   // lectures.id 는 INT
```

**무엇이 문제인가**

`registration.member_id`, `registration.lecture_id`, `lectures.id` 는 모두 INT인데 `setString` 으로 바인딩합니다. MySQL이 문자열을 숫자로 바꿔 주기 때문에 **지금은 동작합니다**. 문제는 변환 실패 시의 동작입니다.

**어떤 상황에서 터지는가** (DB 확인 완료)

MySQL은 숫자가 아닌 문자열을 INT와 비교할 때 예외를 내지 않고 **0으로 변환**합니다. 실제 DB에서 확인한 결과입니다.

```sql
SELECT 'student05' + 0, 'admin01' + 0, '20260001' + 0;
-- 0, 0, 20260001
```

그 결과 "조건에 맞는 행이 없다"는 결과가 조용히 나옵니다. BL-2 의 학번/PK 혼동이 눈에 띄는 오류 없이 지나간 이유가 정확히 이것입니다. 만약 파라미터가 `int` 였다면 학번 문자열을 넘기는 코드는 **애초에 컴파일되지 않아** 그 자리에서 발견됐을 것입니다.

**수정안**

파라미터 타입 자체를 바꿉니다.

```java
public void registerLecture(int memberId, int lectureId) throws SQLException {
    ...
    checkPstmt.setInt(1, lectureId);
```

**왜 그렇게 고치는가**

DB 컬럼 타입과 자바 타입을 일치시키면 잘못된 값이 **컴파일 시점**에 걸립니다. 지금처럼 String으로 받으면 화면에서 `String.valueOf(...)` 로 감싸는 코드가 계속 생기고, 그 안에 무엇이 들어있는지는 아무도 보증하지 못합니다. BL-2 가 정확히 그 경로로 생긴 결함입니다.

---

### [Major] MJ-9. 자원을 닫는 방식이 파일마다 다릅니다

**위치**: 저장소 전반. 대표 위치만 적습니다.

| 방식 | 위치 |
| :--- | :--- |
| Connection만 try-with-resources, Statement/ResultSet은 밖 | `MembersDAO.java:58, 98, 166, 206, 238, 260, 282, 304, 326, 348` (10곳) |
| Connection을 try 밖에서 열고 finally 에서 close | `ScoreDAO.java:81` |
| 3중 중첩 try-with-resources | `LecturesDAO` 전반, `RegistrationDAO:236` |
| try/catch/finally 수동 관리 | `RegistrationDAO:18, 129` (트랜잭션이라 불가피) |

```java
// MembersDAO.java:57-60 — 전형적인 형태
try (Connection connection = DatabaseUtil.getConnection()) {
    PreparedStatement psmt = connection.prepareStatement(sql);   // try() 밖
    psmt.setInt(1, id);
    ResultSet rs = psmt.executeQuery();                          // try() 밖
```

**무엇이 문제인가**

`PreparedStatement` 와 `ResultSet` 이 try-with-resources 괄호 밖에 있어 명시적으로 닫히지 않습니다. 커넥션 누수(사용이 끝난 커넥션을 반납하지 않아 풀이 고갈되고, 결국 새 요청이 커넥션을 받지 못해 멈추는 현상)까지 가지는 않습니다. **HikariCP가 커넥션을 반납할 때 그 커넥션에서 만든 Statement를 대신 닫아 주기 때문입니다.**

다만 이는 HikariCP 덕분이지 코드가 옳아서가 아닙니다. 커넥션 풀 없이 `DriverManager` 를 직접 쓰는 환경으로 바뀌면 그대로 누수가 됩니다.

더 실질적인 문제는 **네 가지 방식이 한 저장소에 공존한다**는 점입니다. 새로 합류한 사람이 어느 방식을 따라야 할지 알 수 없고, 리뷰 때마다 같은 논의를 반복하게 됩니다.

**수정안**

조회는 이 형태로 통일하는 것을 권합니다.

```java
try (Connection conn = DatabaseUtil.getConnection();
     PreparedStatement pstmt = conn.prepareStatement(sql)) {
    pstmt.setInt(1, id);
    try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) { ... }
    }
}
```

`ResultSet` 만 안쪽에 두는 이유는 `executeQuery()` 가 파라미터 바인딩 뒤에 실행되어야 하기 때문입니다.

**왜 그렇게 고치는가**

try-with-resources 괄호에 넣은 자원은 예외가 나든 말든 **역순으로 자동으로 닫힙니다**. 직접 닫으면 중간에 예외가 나는 경로를 하나만 빠뜨려도 누수가 생기고, 그 누수는 평소에는 보이지 않다가 사용자가 몰리는 순간 "프로그램이 멈췄다"로 나타납니다. 원인 찾기가 매우 어려운 종류의 장애입니다.

---

### [Major] MJ-10. 새로 clone 하면 빌드도 실행도 되지 않습니다

**위치**: `.gitignore:241` / 저장소 전체

**무엇이 문제인가**

세 가지가 저장소에 없습니다.

1. **`gradle/wrapper/gradle-wrapper.jar` 가 커밋되어 있지 않습니다.** `.gitignore` 3행에 `!gradle/wrapper/gradle-wrapper.jar` 로 예외 처리를 해 두었지만, 241행의 `*.jar` 규칙이 뒤에 와서 다시 제외시킵니다. git은 **마지막에 일치한 규칙**을 적용합니다.

   ```
   $ git check-ignore -v gradle/wrapper/gradle-wrapper.jar
   .gitignore:241:*.jar    gradle/wrapper/gradle-wrapper.jar
   ```

2. **스키마 DDL(`.sql`)이 없습니다.** 커밋 이력 전체를 확인했으나 `.sql` 파일이 추가된 적이 없습니다. README의 표만으로는 NOT NULL, UNIQUE, FK 동작을 복원할 수 없습니다. 실제로 이번 리뷰에서 DB에 직접 접속하기 전까지 MJ-2, MJ-6, MN-8 의 심각도를 확정하지 못했습니다. (**부록 A에 현재 스키마를 추출해 두었으니 그대로 커밋하면 됩니다.**)

3. **접속 정보가 Discord에만 있습니다.** README에 "🔒 Discord 확인" 으로 적혀 있습니다.

**어떤 상황에서 터지는가**

- 새 팀원이 clone → `./gradlew build` → `Could not find or load main class org.gradle.wrapper.GradleWrapperMain`
- IDE로 열어 컴파일에 성공해도 DB가 없어 실행 불가
- 몇 달 뒤 본인이 다시 열었을 때도 똑같습니다. 포트폴리오로 보여줄 때 가장 곤란해지는 지점입니다.

**수정안**

```bash
git add -f gradle/wrapper/gradle-wrapper.jar
```

`.gitignore` 는 예외 규칙을 `*.jar` **뒤로** 옮깁니다.

```gitignore
# ... Java 섹션의 *.jar 뒤에
!gradle/wrapper/gradle-wrapper.jar
```

스키마는 `db/schema.sql` 로 커밋합니다. `CREATE TABLE` 문과 테스트용 샘플 데이터 `INSERT` 를 함께 두면 누구나 같은 환경을 만들 수 있습니다.

**왜 그렇게 고치는가**

"clone 한 사람이 README만 보고 실행할 수 있는가" 는 프로젝트 완성도의 실질적인 기준입니다. 코드가 아무리 좋아도 돌릴 수 없으면 평가받지 못합니다. wrapper jar를 커밋하는 이유도 같습니다. Gradle이 설치되지 않은 컴퓨터에서도 `./gradlew` 한 줄로 **같은 버전**의 Gradle이 받아지게 하는 것이 wrapper의 존재 이유인데, jar가 빠지면 그 장치가 통째로 무력해집니다.

---

### [Major] MJ-11. 평문 DB 비밀번호가 커밋 이력에 남아 있습니다

**위치**: 커밋 `db7c564` ("scoreDAO 완성") 의 `DatabaseUtil.java`

```java
private static final String PJ_USER = "team1";
private static final String PJ_PASSWORD = "pj1234";
```

**무엇이 문제인가**

현재 HEAD는 환경변수로 되돌려져 있어 최신 코드에는 남아 있지 않습니다. 그러나 **git은 과거를 지우지 않습니다.** 저장소를 clone한 누구나 `git log -p` 한 번으로 볼 수 있습니다.

```
$ git log --all -S'PJ_PASSWORD' --oneline
```

**어떤 상황에서 터지는가**

이 저장소가 GitHub에 공개(public)로 올라가 있다면 이미 노출된 상태입니다 (공개 여부는 **확인 필요**). GitHub에 올라온 자격증명을 자동으로 수집하는 봇이 실제로 돌아다니며, 공개 후 수 분 내에 스캔되는 사례가 보고됩니다. 교육용 내부망 계정이라 피해 범위는 제한적이지만, **실무에서 이런 일이 발생하면 코드 수정이 아니라 해당 계정의 비밀번호 즉시 교체가 첫 조치입니다.**

**수정안**

이번 프로젝트에서 할 일:

1. 강사와 상의해 `team1` 계정 비밀번호를 교체합니다. 이력에서 지우는 것보다 이쪽이 먼저입니다.
2. 저장소가 public이면 private으로 전환을 검토합니다.

앞으로의 예방:

```gitignore
# 접속 정보는 파일로 분리하고 통째로 제외
.env
src/main/resources/db.properties
```

`db.properties.example` 처럼 **값이 빈 예시 파일**만 커밋하면, 새 팀원이 무엇을 채워야 하는지 알면서도 실제 값은 새지 않습니다.

**왜 그렇게 고치는가**

이력에서 완전히 지우려면 `git filter-repo` 로 전체 이력을 다시 쓰고 강제 푸시해야 하는데, 팀원 전원의 로컬 저장소가 깨집니다. 비용이 큽니다. 그래서 실무 원칙은 **"유출된 자격증명은 지우는 게 아니라 무효화한다"** 입니다. 지금 최종 코드가 환경변수를 쓰고 있는 것은 방향이 맞습니다. 중간에 한 번 하드코딩했던 것이 남았을 뿐이며, 이런 일이 실제로 어떻게 생기는지 보여주는 좋은 사례이기도 합니다.

---

### [Minor] MN-1. DAO와 Service가 화면에 직접 출력합니다

**위치**: `LecturesDAO` 4곳, `MembersDAO` 1곳, `RegistrationService` 6곳, `LecturesService` 1곳

```java
// LecturesDAO.java:97
System.out.println("신규 강의 정보가 " + rows + " 건 추가되었습니다.");
// MembersDAO.java:140
System.out.println(rows + "행이 추가됨.");
// RegistrationService.java:22
System.out.println("수강 신청이 성공적으로 완료되었습니다.");
```

**무엇이 문제인가**

DAO는 DB와 대화하는 계층이고 Service는 업무 규칙을 담는 계층입니다. 둘 다 "사용자가 지금 콘솔 앞에 앉아 있다"는 사실을 알면 안 됩니다.

**어떤 상황에서 문제가 되는가**

같은 저장소에 이미 Swing 화면이 있습니다. Swing으로 강의를 등록하면 콘솔에 "신규 강의 정보가 1 건 추가되었습니다" 가 출력되지만 사용자는 그 창을 보고 있지 않습니다. 반대로 콘솔에서는 DAO의 메시지와 View의 메시지가 둘 다 나와 **같은 내용이 두 번** 찍힙니다.

**수정안**: DAO와 Service에서 `System.out` 을 전부 제거하고, 결과는 반환값으로 올립니다. 기록이 필요하면 이미 의존성에 들어 있는 SLF4J를 씁니다.

```java
private static final Logger log = LoggerFactory.getLogger(LecturesDAO.class);
log.debug("강의 등록 완료. rows={}", rows);
```

**왜 그렇게 고치는가**: 계층을 나눈 이유는 화면을 바꿔도 아래가 그대로 재사용되게 하기 위해서입니다. 아래 계층이 화면에 직접 출력하는 순간 그 이점이 사라집니다. `build.gradle` 에 SLF4J를 이미 넣어 두었으니 활용하면 됩니다.

---

### [Minor] MN-2. 반환값이 항상 비어 있는 메서드가 있습니다

**위치**: `dao/RegistrationDAO.java:129-216`

```java
public List<Registration> deleteRegistration(String memId, String lecId) throws SQLException {
    List<Registration> registrationList = new ArrayList<>();
    ...   // registrationList 에 무언가를 담는 코드가 없음
    return registrationList;
}
```

`RegistrationService.deleteRegistration` 은 이를 `remainingList` 라는 이름으로 받아 그대로 반환하고, `LmsView:197` 은 결과를 쓰지 않고 다시 조회합니다. 이름은 "남은 목록" 인데 실제로는 항상 빈 리스트입니다.

**수정안**: 반환형을 `void` 로 바꾸거나, 삭제 성공 여부인 `boolean` 로 바꿉니다.

**왜 그렇게 고치는가**: 이름과 실제가 다른 반환값은 다음 사람을 반드시 속입니다. 누군가 `if (remainingList.isEmpty())` 로 "남은 수강신청이 없다"를 판단하는 코드를 쓰면 항상 참이 됩니다.

---

### [Minor] MN-3. 실행될 수 없는 catch 블록이 있습니다

**위치**: `service/RegistrationService.java:19-27`

```java
try {
    registrationDAO.registerLecture(memId, lecId);
    ...
} catch (SQLException e) {
    System.out.println("수강 신청 실패: " + e.getMessage());
    throw new RuntimeException(e);
}
```

`registerLecture` 는 선언에 `throws SQLException` 이 있지만, 내부에서 SQLException을 모두 잡아 `RuntimeException` 으로 바꿔 던집니다 (`RegistrationDAO:113`). 따라서 이 `catch (SQLException e)` 에는 아무것도 도달하지 않습니다. 실제 오류는 `RuntimeException` 으로 그냥 통과해 `LmsView` 까지 올라갑니다.

**수정안**: DAO가 예외를 바꿔 던지지 않고 `SQLException` 그대로 올리거나, 반대로 DAO 시그니처에서 `throws SQLException` 을 떼는 것 중 하나로 정합니다.

**왜 그렇게 고치는가**: 예외를 다른 타입으로 바꿔 던지면(wrapping) 호출부의 `catch` 가 전부 무의미해집니다. "어느 계층에서 예외 타입을 바꿀 것인가"를 한 번 정해 두면 이런 코드가 생기지 않습니다.

---

### [Minor] MN-4. 테스트가 0건입니다

**위치**: `src/test/java/com/tenco/service/MemberServiceTest.java` (전체 49줄이 주석)

`build.gradle` 에 JUnit 5 설정이 되어 있고 테스트도 작성되어 있는데, 파일 전체가 주석 처리되어 실행되지 않습니다. 원인은 `MemberService` 의 생성자 주입이 함께 주석 처리된 것으로 보입니다.

```java
// MemberService.java:11-15
//    private final MembersDAO membersDAO;
//
//    public MemberService() {
//        this(new MembersDAO());
//    }
private final MembersDAO membersDAO = new MembersDAO();   // 실제로 쓰이는 코드
```

**무엇이 문제인가**

`new MembersDAO()` 를 필드에서 직접 만들면 테스트에서 가짜 DAO로 바꿔 끼울 수 없습니다. 그래서 테스트가 컴파일되지 않고, 주석 처리로 해결한 상태입니다.

주석 처리된 테스트는 잘 짜여 있습니다. DB 없이 입력 검증만 확인하는 방식이라 실행 환경도 필요 없습니다.

**수정안**: `RegistrationService` 가 이미 쓰고 있는 방식(생성자 주입)으로 맞추면 주석을 그대로 해제할 수 있습니다.

```java
public class MemberService {
    private final MembersDAO membersDAO;

    public MemberService() { this(new MembersDAO()); }
    public MemberService(MembersDAO membersDAO) { this.membersDAO = membersDAO; }
```

**왜 그렇게 고치는가**: 필요한 것을 밖에서 받으면 테스트에서 가짜로 바꿔 끼울 수 있고, 안에서 만들면 못 바꿉니다. 이것이 생성자 주입을 쓰는 실질적인 이유입니다. Blocker 3건이 전부 "실행해 보지 않아서" 생긴 것을 감안하면, 테스트 한 벌만 돌아가도 체감 효과가 큽니다.

같은 저장소 안에 두 방식이 공존합니다 (`RegistrationService` 는 주입, 나머지 3개는 필드 생성). 한쪽으로 통일할 후보로 적합합니다.

---

### [Minor] MN-5. 1회용 마이그레이션 코드가 `main` 과 함께 남아 있습니다

**위치**: `src/main/java/com/tenco/util/HashTest.java`

```java
String selectSql = "SELECT id, password FROM members WHERE id <= 12";
...
public static void main(String[] args) {   // 실행 가능한 상태로 남아 있음
```

주석에도 "최초 1회 실행 후 주석 처리 또는 삭제" 라고 적혀 있으나 그대로 있습니다. `id <= 12` 라는 숫자에는 설명이 없습니다.

**현재 데이터는 문제없습니다** (DB 확인 완료). 회원 15명(id 1~18) 전원이 BCrypt 해시 상태입니다. 13번 이후 회원은 화면의 학생 등록 기능으로 만들어졌고, 그 경로(`MemberService.registerMember`)가 해시를 걸어 주기 때문입니다.

```
pw_type      cnt  min_id  max_id
BCrypt해시   15   1       18
```

문제는 이 코드가 **지금 실행되면** 생깁니다. `id <= 12` 조건 때문에 13번 이후는 건드리지 않으므로, 누군가 DB에 직접 평문 비밀번호를 INSERT한 뒤 이 도구를 돌리면 그 계정만 평문으로 남습니다. 조건에 근거가 없다는 것이 문제입니다.

**수정안**: 삭제하고 필요하면 `db/migration.sql` 등 별도 위치에 스크립트로 남깁니다. 유지한다면 조건을 id 범위가 아니라 상태 기준으로 바꾸는 편이 의도에 맞습니다.

```sql
WHERE password NOT LIKE '$2a$%'
```

**왜 그렇게 고치는가**: `main` 이 있는 클래스는 누구나 실행할 수 있습니다. DB 데이터를 통째로 바꾸는 코드가 실행 가능한 상태로 방치되어 있는 것은 위험합니다. 클래스 이름이 `HashTest` 인데 실제로는 테스트가 아니라 마이그레이션 도구인 점도 오해를 부릅니다.

---

### [Minor] MN-6. 커넥션 풀이 종료되지 않습니다

**위치**: `util/DatabaseUtil.java:32-36` — `close()` 메서드를 아무도 호출하지 않습니다.

`LmsView.start()` 가 `return` 해도 HikariCP의 커넥션과 내부 스레드가 살아 있어 JVM이 바로 종료되지 않을 수 있습니다.

**수정안**

```java
// Main.java
public static void main(String[] args) {
    try {
        new LmsView().start();
    } finally {
        DatabaseUtil.close();
    }
}
```

**왜 그렇게 고치는가**: 연 것은 닫는다는 원칙이 자원 관리의 기본입니다. `close()` 를 만들어 두고 부르지 않은 것이라 한 줄로 끝납니다.

---

### [Minor] MN-7. 로그인의 핵심 조건에 설명이 없어 삭제되기 쉽습니다

**위치**: `dao/MembersDAO.java:22`

```java
String sql = "SELECT ... FROM members WHERE member_id = ?";
...
if (rs.next() && memberId.equals(rs.getString("member_id")) && BCrypt.checkpw(...)) {
```

**무엇이 문제인가**

언뜻 보면 `WHERE member_id = ?` 로 조회했으니 가운데 조건은 항상 참인 중복 검사처럼 보입니다. **실제로는 그렇지 않습니다.**

DB의 문자 집합을 확인한 결과 `utf8mb4_0900_ai_ci` 입니다. 끝의 `ci` 는 case-insensitive, 즉 **대소문자를 구분하지 않는다**는 뜻입니다. 실제 확인 결과입니다.

```sql
SELECT 'ADMIN02' AS 입력값, member_id AS DB가_돌려준_값
FROM members WHERE member_id = 'ADMIN02';
-- ADMIN02 | admin02      ← 대문자로 찾았는데 소문자 행이 걸린다
```

즉 사용자가 `ADMIN02` 로 로그인해도 DB는 `admin02` 행을 돌려줍니다. 이때 자바의 `"ADMIN02".equals("admin02")` 는 `false` 이므로 로그인이 거부됩니다. **이 한 줄이 아이디 대소문자를 구분하게 만드는 유일한 장치입니다.**

**어떤 상황에서 문제가 되는가**

코드 자체는 동작합니다. 문제는 **이 줄이 왜 있는지 아무 설명이 없다는 것**입니다. 다음 사람이 "WHERE 절이 이미 걸렀는데 왜 또 비교하지" 라고 판단해 지우면, 그날부터 `ADMIN02`, `Admin02`, `aDmIn02` 가 전부 로그인됩니다. 아이디 정책이 조용히 바뀌는 것이고, 코드 리뷰에서 발견하기 매우 어렵습니다.

**수정안**

의도된 것이라면 주석으로 못 박습니다.

```java
// MySQL 기본 콜레이션(utf8mb4_0900_ai_ci)은 대소문자를 구분하지 않는다.
// 아이디 대소문자를 구분하기 위해 자바에서 한 번 더 비교한다. 지우지 말 것.
if (rs.next() && memberId.equals(rs.getString("member_id")) && BCrypt.checkpw(...)) {
```

반대로 대소문자를 구분하지 않는 것이 정책이라면 이 조건을 빼야 합니다. 어느 쪽인지 팀이 정해야 할 사항입니다 — **확인 필요**.

**왜 그렇게 고치는가**

"왜 이 코드가 여기 있는가"가 코드만 봐서 드러나지 않을 때 주석을 씁니다. 반대로 코드를 읽으면 알 수 있는 내용(`// id로 조회한다`)에는 주석이 필요 없습니다. 이 줄은 정확히 전자에 해당합니다. DB 콜레이션이라는 **코드 밖의 사정**에 의존하기 때문입니다.

---

### [Minor] MN-8. 화면 단의 중복 검사가 동시 요청을 막지 못합니다

**위치**: `view/LmsView.java:159-164` (수강신청 중복), `:667-672` (성적 중복)

```java
List<Registration> registrations = registrationService.getMyLectureList(...);
for (Registration registration : registrations) {
    if (registration.getLectureId() == lecture.getId()) {
        System.out.println("이미 수강신청한 과목입니다.");
        return;
    }
}
```

조회하고 확인한 뒤 INSERT 하는 사이에 다른 창에서 같은 신청이 들어오면 중복 행이 생깁니다. 정원 검사에는 `FOR UPDATE` 로 락을 걸어 이 문제를 해결했는데, 중복 신청 검사는 화면에만 있습니다.

**DB에 막아 주는 장치가 없습니다** (확인 완료). `registration` 테이블의 제약은 PK와 외래키 두 개뿐이고, `UNIQUE (member_id, lecture_id)` 는 없습니다. 같은 학생이 같은 강의를 두 번 신청한 행을 DB가 그대로 받습니다.

현재 데이터에 중복은 0건입니다. 화면 검사가 단일 사용자 환경에서는 잘 동작하고 있다는 뜻이며, 결함이 없어서가 아니라 아직 부딪히지 않았을 뿐입니다. 참고로 `members.member_id` 와 `lectures.lecture_code` 에는 UNIQUE가 걸려 있습니다. 같은 팀이 어떤 테이블에는 제약을 넣고 어떤 테이블에는 빠뜨린 것입니다.

**수정안**: 스키마에 UNIQUE 제약을 추가하고, `registerLecture` 안에서 `SQLIntegrityConstraintViolationException` 을 잡아 "이미 신청한 과목입니다"로 변환합니다.

```sql
ALTER TABLE registration ADD UNIQUE KEY uk_member_lecture (member_id, lecture_id);
ALTER TABLE scores ADD UNIQUE KEY uk_member_lecture (member_id, lecture_id);
```

`scores` 도 같은 상태이므로 함께 처리하는 편이 좋습니다.

**왜 그렇게 고치는가**: "조회 후 판단 후 쓰기" 사이에는 항상 틈이 있습니다. 마지막 방어선은 DB 제약조건이어야 합니다. 화면 검사는 사용자 경험을 위한 것이고, 데이터 정합성을 지키는 것은 제약조건입니다. 정원 쪽에서는 이 원리를 이미 적용했으므로, 같은 기준을 중복 신청에도 적용하면 됩니다.

---

### [Minor] MN-9. DTO가 여러 역할을 겸하고 있습니다

**위치**: `dto/Members.java`

```java
private String password;   // 화면 출력용 객체에 남아 있음
private Integer score;     // 테이블에 없는 조회 전용 계산값(평균)
```

`password` 는 로그인 결과에는 담기지 않지만(3-2) 필드 자체는 존재해서, `@Data` 가 만든 `toString()` 을 호출하면 해시가 출력될 수 있습니다. `score` 는 `members` 테이블에 없는 `round(avg(s.score))` 결과이며 `addMember` 경로에서는 항상 null입니다.

**수정안**: 지금 단계에서는 주석으로 의도를 남기는 것으로 충분합니다. 다음 단계에서는 저장용 DTO와 화면 출력용 DTO를 나누는 방법을 살펴보면 좋습니다.

**왜 그렇게 고치는가**: 하나의 클래스가 "DB 테이블 한 행", "화면에 보여줄 정보", "로그인 세션" 세 가지를 겸하면, 어떤 필드가 채워져 있는지 아무도 확신하지 못합니다. MJ-1 의 `lectureCode = null` 도 같은 뿌리입니다.

---

### [Nit] 그 외

| 항목 | 위치 | 내용 |
| :--- | :--- | :--- |
| 잘못 자동 임포트된 클래스 | `MembersDAO.java:7` | `import java.lang.reflect.Member;` — DTO `Members` 와 무관한 클래스가 IDE 자동완성으로 들어옴. 미사용 |
| 미사용 임포트 | `LecturesService.java:4-5` | `MembersDAO`, `ScoreDAO` 를 쓰지 않음 |
| DTO 이름이 복수형 | `Members`, `Lectures`, `Scores` | 객체 하나가 한 건을 담는데 이름은 복수형. `Member`, `Lecture`, `Score` 가 자연스러움 |
| 설계 메모가 코드에 남음 | `MemberService.java:17-63` (47줄) | "둘 중 필요없는건 삭제 예정" 등. 이런 논의는 이슈나 PR 설명에 |
| 애너테이션 불일치 | `dto/Registration.java` | 다른 DTO 3개에는 `@ToString` 이 있는데 이것만 없음 |
| 변수명 축약 | `LecturesDAO` 의 `llsql`, `srs`, `llrs` | 읽는 사람이 해석해야 함. `sql`, `rs` 로 충분 |
| SQL 문자열 결합 | `LecturesDAO.java:47-49` | 텍스트 블록을 `+=` 로 이어 붙임. 조건이 늘면 `StringBuilder` 가 읽기 쉬움 |
| 기본값이 두 곳에 | `LecturesDAO.java:87-92` | DB의 `professor` 컬럼에 이미 `DEFAULT '미정'` 이 걸려 있는데 자바에서도 "미정"을 넣습니다. 한쪽을 바꾸면 다른 쪽과 어긋납니다. DB 기본값에 맡기고 자바에서는 `null` 을 넘기는 편이 단순합니다 |
| README와 스키마 차이 | `README.md` | 스키마 표에 UNIQUE 제약과 `score` 의 NULL 허용 여부가 빠져 있습니다. `members.grade` 설명이 "학년 / 성적"으로 두 가지를 겸하게 적혀 있어 오해를 부릅니다 (실제로는 학년) |
| 빈 입력 허용 | `LmsView.java:486` | 관리자 학생 조회에 `readText` 사용. `readRequiredText` 가 일관적 |
| boolean 읽는 방식 불일치 | `MembersDAO:29` vs `:106` | `rs.getInt("admin") == 1` 과 `rs.getBoolean("admin")` 이 혼재 |

---

## 5. 담당 기능별 정리

지적 사항은 위에서 이미 다뤘으므로, 여기서는 **기능 단위로 지금 어떤 상태인지**만 정리합니다.

### 회원

| 항목 | 상태 |
| :--- | :--- |
| 잘된 점 | BCrypt 해시 저장과 검증, 로그인 객체에 비밀번호 미포함, LEFT JOIN + GROUP BY 평균 조회, `getObject` 로 NULL 구분 |
| 고칠 점 | 자원 관리 방식이 다른 파일과 다름 (MJ-9, 10곳), 입력 검증에 `SQLException` 18곳 (MJ-7), 테스트가 주석 처리됨 (MN-4) |
| 눈에 띄는 구조 | 수정 메서드가 필드별로 5개(`updateMemberId/Name/Phone/Major/Password`)로 나뉘어 있습니다. 필드가 늘 때마다 메서드가 하나씩 늘어나는 구조지만, 화면이 "무엇을 수정할지" 먼저 묻는 흐름과는 잘 맞습니다. 지금 단계에서는 문제 없습니다 |
| DB 검증 결과 | `member_id` 에 UNIQUE 제약이 있어 학번 중복은 DB가 막아 줍니다. 다만 자바 쪽에 사전 확인이 없어, 중복 등록을 시도하면 `Duplicate entry '...' for key 'member_id'` 라는 DB 원문이 화면에 그대로 나옵니다. 회원 15명 전원 BCrypt 해시 상태도 확인했습니다 |

### 강의

| 항목 | 상태 |
| :--- | :--- |
| 잘된 점 | `WHERE 1 = 1` 기반 동적 검색, 매핑 메서드 추출(`createLectures`), 교수명 미입력 시 "미정" 기본값, 수정 시 빈 입력은 기존 값 유지 |
| 고칠 점 | 예외를 삼키고 0을 반환 (MJ-6), `available` 을 관리자가 임의로 뒤집을 수 있음 (MJ-3), DAO의 화면 출력 4곳 (MN-1) |
| 눈에 띄는 구조 | `LecturesService.updateLectures` 가 기존 값을 조회해 빈 항목만 덮어쓰는 방식은 좋습니다. "부분 수정"을 DTO 하나로 처리하는 일반적인 패턴입니다 |
| DB 검증 결과 | FK가 `NO ACTION` 이라 수강생이 있는 강의는 삭제되지 않습니다. 현재 6개 강의 전부에 수강신청이 걸려 있어, **지금은 어떤 강의도 삭제할 수 없는 상태**입니다. 그리고 그 실패가 MJ-6 때문에 "강의를 삭제하지 못했습니다" 로만 표시됩니다. 또한 6개 중 2개의 `available` 이 실제 인원과 어긋나 있습니다 (MJ-3) |

### 수강

| 항목 | 상태 |
| :--- | :--- |
| 잘된 점 | `FOR UPDATE` 비관적 락, 락 이후 재COUNT, 트랜잭션 rollback 처리, `finally` 에서 `setAutoCommit(true)` 복원 후 반납 |
| 고칠 점 | **실행 결함 3건이 전부 이 영역에 있습니다** (BL-1 취소 불가, BL-2 식별자 불일치, BL-3 전체 조회 실패). 추가로 MJ-1(강의코드 null), MJ-5(commit 후 throw), MJ-8(INT에 setString) |
| 판단 | 설계 수준은 네 영역 중 가장 높은데 실행 검증이 가장 부족합니다. 동시성까지 고민한 코드가 문자열 `==` 비교 하나로 동작하지 않는 상태입니다. **고칠 양은 적고 효과는 큽니다** |
| DB 검증 결과 | `registration` 에 `UNIQUE (member_id, lecture_id)` 가 없어 중복 신청을 DB가 막지 못합니다 (MN-8). 현재 중복 데이터는 0건입니다. 수강신청 13건은 정상 상태입니다 |

### 성적

| 항목 | 상태 |
| :--- | :--- |
| 잘된 점 | Service의 방어적 검증이 가장 촘촘함(회원 존재 → 강의 존재 → 점수 범위), 트랜잭션 처리에서 `addSuppressed` 로 롤백 실패까지 보존 |
| 고칠 점 | 점수 없이 INSERT (MJ-2, 심각도는 스키마에 달림), `updateScore` 만 자원 관리 방식이 다름 (MJ-9), 입력 검증에 `SQLException` 11곳 (MJ-7) |
| 눈에 띄는 구조 | 주석에 처리 순서를 번호로 적어둔 것(`ScoreDAO:105-113`)은 좋은 습관입니다. 다만 실제 구현이 주석의 2~3번(학생/과목 존재 확인)을 Service로 옮겨간 뒤 주석만 남았습니다. **주석과 코드가 어긋나면 주석을 갱신해야 합니다** |
| DB 검증 결과 | `scores.score` 는 `int DEFAULT NULL` 입니다. 따라서 성적 추가는 실패하지 않고 **점수가 빈 행**을 남기며, 실제로 10건 중 1건이 이미 그 상태입니다 (MJ-2). `scores` 에도 UNIQUE 제약이 없어 같은 학생·같은 과목의 성적 행이 여러 개 생길 수 있습니다 |

### 공통 / 화면

| 항목 | 상태 |
| :--- | :--- |
| 잘된 점 | HikariCP 풀 설정, 환경변수로 자격증명 분리, 입력 검증 메서드 분리, 삭제 전 확인 절차, 관리자/학생 메뉴 분기 |
| 고칠 점 | 풀 종료 미호출 (MN-6), `throws SQLException` 이 화면 전체에 전파됨 (MJ-7의 결과), 빌드 재현 불가 (MJ-10) |
| 눈에 띄는 구조 | `LmsView` 가 715줄입니다. 메뉴별 메서드 분리는 되어 있으나 파일 하나가 네 도메인을 모두 담고 있습니다. 담당자별 병렬 작업 시 충돌이 집중되는 지점이며, 실제로 커밋 이력의 "view 1차/2차/3차 수정" 이 이를 보여줍니다. 도메인별로 나누는 방법을 다음 프로젝트에서 시도해 보면 좋습니다 |

---

## 6. 코드 컨벤션과 Git 관리

### 6-1. 팀 규칙이 없어서 갈린 지점

아래는 개인의 실수가 아니라 **팀이 정하지 않아서 생긴 차이**입니다. 규칙을 하나 정하면 전부 사라집니다.

| 항목 | 갈린 방식 | 확인된 위치 |
| :--- | :--- | :--- |
| 자원 관리 | 4가지 (MJ-9 표 참조) | DAO 4개 전부 |
| 예외 타입 | `RuntimeException(e)` / `IllegalStateException` / `SQLException` 그대로 / 삼키고 println | DAO 4개 |
| 입력 검증 실패 | `SQLException` 31곳 vs `IllegalArgumentException` 1곳 | Service 4개 |
| DAO 주입 | 생성자 주입 1개 vs 필드에서 `new` 3개 | Service 4개 |
| boolean 읽기 | `getInt(...) == 1` vs `getBoolean(...)` | `MembersDAO:29` vs `:106` |
| SQL 키워드 | 대문자 (`SELECT`) vs 소문자 (`select`) | `LecturesDAO`/`RegistrationDAO` vs `MembersDAO`/`ScoreDAO` |
| DAO 메서드 이름 | `searchXxx` vs `getXxx` | `MembersDAO` vs 나머지 |
| 화면 출력 위치 | DAO / Service / View 전부 | MN-1 참조 |

특히 **SQL 대소문자**는 파일을 열자마자 "다른 사람이 썼다"는 느낌을 주는 항목입니다. 기능 분담을 하면 자연히 생기는 차이이므로, 시작 전 30분 회의로 정해 두면 됩니다.

### 6-2. Git 이력

실제로 확인한 수치입니다.

| 항목 | 수치 | 판단 |
| :--- | :--- | :--- |
| 전체 커밋 | 134 | 6일간(09-11 ~ 09-16). 활동량은 충분 |
| 머지 커밋 | 61 (45.5%) | 과다 |
| 저자 식별자 | 8종 (실제 5명) | 정리 필요 |
| 브랜치 명명 규칙 | 4가지 | 통일 필요 |

**(1) 머지 커밋이 전체의 45%입니다**

`git pull` 을 할 때마다 자동으로 머지 커밋이 생긴 결과로 보입니다. 이력에 `Merge branch 'main' of https://github.com/...` 이 반복되고, 같은 커밋 메시지가 2번씩 나타나는 쌍이 15개 있습니다.

```
2 view 1차수정
2 view 2차 수정본
2 view 3차 수정
2 swing 수정
2 동시성문제수정
...
```

**실무였다면 무엇이 문제인가**: 이력이 갈래로 얽혀서 `git log --graph` 로 봐도 "이 기능이 언제 들어왔는지" 따라가기 어렵습니다. 장애가 나서 원인 커밋을 찾을 때 이력의 절반이 머지 커밋이면 `git bisect` 같은 도구의 효율이 크게 떨어집니다.

**개선**: `git pull` 대신 `git pull --rebase` 를 쓰면 머지 커밋 없이 내 작업이 최신 main 위로 옮겨집니다. 아래를 한 번 설정하면 계속 적용됩니다.

```bash
git config --global pull.rebase true
```

**(2) 5명인데 저자 식별자가 8종입니다**

```
62  is-hyun     <i.suhyun1024@gmail.com>
30  수현        <i.suhyun1024@gmail.com>   ← 위와 같은 사람
15  I3abel      <wlsdn48971@gmail.com>
 1  I3abel      <jinwoo_dev@naver.com>     ← 같은 사람, 다른 이메일
11  morningMoka <random0815@naver.com>
10  dalyume2876 <bold20030@gmail.com>
 1  dalyume2876 <...@users.noreply.github.com>  ← GitHub 웹에서 편집
 4  현재        <a67286268@gmail.com>
```

한 사람이 집과 학원에서 `user.name` 을 다르게 설정하거나, GitHub 웹 편집기를 섞어 쓰면 이렇게 갈립니다. 누구의 잘못도 아니고, 팀에서 한 번 맞추지 않으면 반드시 생기는 현상입니다.

**실무였다면 무엇이 문제인가**: GitHub의 기여도 그래프가 사람 단위로 집계되지 않습니다. 누가 어느 영역을 맡았는지 이력만으로 알 수 없고, `git blame` 으로 작성자를 찾을 때도 헷갈립니다. 회사에서는 사내 이메일 외의 커밋을 CI가 거부하도록 설정하는 경우도 있습니다.

**개선**: 프로젝트 시작 시 각자 저장소에서 한 번 설정합니다.

```bash
git config user.name "본인이 정한 표기 하나"
git config user.email "GitHub 계정에 등록된 이메일"
```

이메일이 GitHub 계정에 등록된 것과 같아야 기여도에 반영됩니다. 이미 갈라진 이력은 저장소 루트에 `.mailmap` 파일을 두면 통계에서만 합칠 수 있습니다.

```
# .mailmap — 왼쪽이 대표 표기, 오른쪽이 합칠 대상
이수현 <대표@example.com> <다른표기@example.com>
```

**(3) 커밋 집중도**

이메일 기준으로 합치면 최다 기여자 한 명이 92커밋(69%)입니다. 화면 통합과 Swing 작업이 한 사람에게 모인 결과입니다. 커밋 수가 곧 기여도는 아니고, 통합 작업은 원래 커밋이 잘게 쪼개지는 성격이라는 점은 감안해야 합니다.

**실무였다면 무엇이 문제인가**: 개인의 문제가 아니라 **분담 방식의 문제**입니다. 통합을 한 사람이 전담하면 그 사람이 빠질 때 프로젝트가 멈추고(버스 팩터 1), 나머지 팀원은 "내 기능이 화면에서 어떻게 쓰이는지" 를 경험하지 못한 채 끝납니다.

이번 Blocker 3건이 전부 화면-서비스 연결부에 몰려 있는 것도 같은 맥락입니다. 통합하는 사람은 네 도메인의 규칙을 전부 외울 수 없고(예: 수강신청이 PK를 받는지 학번을 받는지), 도메인 담당자는 통합 결과를 볼 기회가 없었습니다. 결함이 **아무도 보지 않는 경계선**에 쌓인 것입니다.

**개선**: 각 도메인 담당자가 자기 기능의 화면 연결까지 책임지거나, 통합본이 나온 뒤 담당자별로 자기 메뉴를 한 번씩 눌러 보는 절차를 넣습니다. 후자는 30분이면 끝나고, 이번 Blocker 3건은 거기서 전부 걸렸을 것입니다.

**(4) 커밋 메시지**

```
view 1차수정  /  view 2차 수정본  /  view 3차 수정
fix  /  구현  /  수정  /  registration
코드 오류 ì수정 및 예외처리, 코드 리ì팩토ì링   ← 인코딩 깨짐
```

"무엇을 왜 바꿨는지" 를 알 수 없습니다. 반면 잘 쓴 것도 있습니다.

```
내 수강 신청 조회 메서드 매개변수 수정 및 수강 DTO 수정
서비스 리턴값 오류 수정
```

**실무였다면 무엇이 문제인가**: 6개월 뒤 "이 코드는 왜 이렇게 됐지" 를 확인할 유일한 근거가 커밋 메시지입니다. "3차 수정본" 은 아무 정보도 주지 않습니다.

**개선**: `[영역] 무엇을 왜` 한 줄이면 충분합니다.

```
수강신청: 정원 확인에 FOR UPDATE 추가 (동시 신청 시 정원 초과되던 문제)
회원: 비밀번호 검증 조건을 8자 이상 + 특수문자로 변경
```

**(5) 브랜치 이름**

```
f/regist   f/regist-fix   feature/score   members/dalyume
```

접두어가 `f/`, `feature/`, 도메인명 세 가지입니다. `members/dalyume` 은 사람 이름이 들어가 있어 다른 것과 규칙이 다릅니다.

**개선**: `feature/기능명` 하나로 통일합니다. 사람 이름은 커밋 저자로 이미 남으므로 브랜치 이름에 넣지 않습니다.

**(6) 첫 커밋**

`first commit` 에 17개 파일 733줄이 한 번에 들어왔습니다. 초기 세팅이라 불가피한 면이 있으나, `.gitignore` 를 먼저 커밋하고 시작하면 `gitignore 수정`, `gitignore 추적 초기화` 같은 뒤따르는 정리 커밋을 줄일 수 있습니다.

**(7) 잘한 점**

- 기능별 브랜치를 실제로 만들어 작업하고 main에 머지했습니다. 전원이 main에 직접 커밋하는 방식보다 훨씬 낫습니다.
- `.gitignore` 에 `build/`, `.idea/`, `.gradle/` 을 넣어 빌드 산출물과 IDE 설정을 제외했습니다 (MJ-10 의 wrapper jar 건은 예외 규칙 순서 문제일 뿐, 방향은 맞습니다).
- README에 역할 분담표와 스키마 정의를 정리했습니다. 접속 정보를 저장소에 쓰지 않고 별도 채널로 돌린 판단도 맞습니다.

---

## 7. 다음 프로젝트를 위한 체크리스트

### 시작 전 30분 회의에서 정할 것

- [ ] SQL 키워드 대소문자 — 대문자 / 소문자 중 하나
- [ ] DAO 메서드 이름 접두어 — `get` / `search` / `find` 중 하나
- [ ] 자원 관리 — try-with-resources 형태 하나를 정하고 예시 코드를 공유
- [ ] 예외 — 입력 검증 실패는 `IllegalArgumentException`, DB 오류는 그대로 올리기 같은 규칙
- [ ] 화면 출력은 View에서만. DAO/Service에 `System.out` 금지
- [ ] DAO 주입 방식 — 생성자 주입으로 통일 (테스트를 위해)
- [ ] 브랜치 이름 — `feature/기능명`
- [ ] 커밋 메시지 — `[영역] 무엇을 왜`
- [ ] `git config user.name` / `user.email` 전원 통일
- [ ] `git config pull.rebase true` 전원 설정

### 저장소에 반드시 들어가야 할 것

- [ ] `db/schema.sql` — `CREATE TABLE` + 제약조건 + 샘플 데이터 (**부록 A에 현재 운영 스키마를 그대로 옮겨 두었습니다. 복사해서 커밋하면 됩니다**)
- [ ] `gradle/wrapper/gradle-wrapper.jar`
- [ ] README에 "clone 후 실행하는 법" 3~5줄
- [ ] `.env.example` 또는 `db.properties.example` (값은 비워서)

### 저장소에 절대 들어가면 안 되는 것

- [ ] 비밀번호, API 키 — **한 번이라도 커밋하면 이력에 영원히 남습니다.** 실수했다면 코드 수정보다 **비밀번호 교체**가 먼저입니다
- [ ] 빌드 산출물(`build/`), IDE 설정(`.idea/`)

### 기능을 "완료" 라고 부르기 전에

- [ ] 그 메뉴를 실제로 눌러서 결과 화면을 봤는가
- [ ] 정상 흐름뿐 아니라 **예외 흐름**도 눌러봤는가 (없는 값, 빈 입력, 남의 데이터, 중복)
- [ ] DB를 직접 열어 의도한 대로 들어갔는지 확인했는가
- [ ] 본인 기능을 화면에 연결한 사람이 본인이 아니라면, 연결한 결과를 본인이 한 번 확인했는가

> 이번 Blocker 3건은 전부 마지막 항목에서 걸렸을 문제입니다. 코드를 읽어서는 잘 안 보이고, **한 번 눌러보면 즉시 보입니다.**

### 다음 단계에서 시도해 볼 것

- [ ] 트랜잭션 경계를 Service로 올리기 (Connection을 파라미터로 넘기는 방식 — MJ-4)
- [ ] DB 없이 돌아가는 단위 테스트 한 벌 (`MemberServiceTest` 를 되살리는 것부터)
- [ ] 파생 데이터(`available`)를 저장하지 않고 조회 시 계산하기 (MJ-3)
- [ ] 화면 클래스를 도메인별로 분리하기 (`LmsView` 715줄)

---

## 부록 A. 실제 DB 스키마

MJ-10 에서 지적한 "저장소에 스키마가 없다" 를 바로 해결할 수 있도록, 운영 중인 `project_team1` 에서 추출한 정의를 옮겨 둡니다. **이 내용을 `db/schema.sql` 로 저장해 커밋하면 됩니다.**

```sql
CREATE TABLE `members` (
  `id`        int          NOT NULL AUTO_INCREMENT,
  `member_id` varchar(50)  NOT NULL,
  `password`  varchar(255) NOT NULL,
  `name`      varchar(50)  NOT NULL,
  `phone`     varchar(20)  NOT NULL,
  `major`     varchar(50)  NOT NULL,
  `grade`     int          NOT NULL,
  `admin`     tinyint(1)   NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `lectures` (
  `id`           int          NOT NULL AUTO_INCREMENT,
  `lecture_code` varchar(20)  NOT NULL,
  `lecture_name` varchar(100) NOT NULL,
  `professor`    varchar(50)  DEFAULT '미정',
  `credit`       int          NOT NULL,
  `capacity`     int          NOT NULL,
  `available`    tinyint(1)   NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `lecture_code` (`lecture_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `registration` (
  `id`         int NOT NULL AUTO_INCREMENT,
  `member_id`  int NOT NULL,
  `lecture_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `member_id` (`member_id`),
  KEY `lecture_id` (`lecture_id`),
  CONSTRAINT `registration_ibfk_1` FOREIGN KEY (`member_id`)  REFERENCES `members` (`id`),
  CONSTRAINT `registration_ibfk_2` FOREIGN KEY (`lecture_id`) REFERENCES `lectures` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `scores` (
  `id`         int NOT NULL AUTO_INCREMENT,
  `member_id`  int NOT NULL,
  `lecture_id` int NOT NULL,
  `score`      int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `member_id` (`member_id`),
  KEY `lecture_id` (`lecture_id`),
  CONSTRAINT `scores_ibfk_1` FOREIGN KEY (`member_id`)  REFERENCES `members` (`id`),
  CONSTRAINT `scores_ibfk_2` FOREIGN KEY (`lecture_id`) REFERENCES `lectures` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

MN-8 에서 권장한 제약은 위 정의에 없습니다. 아래를 이어서 실행하면 추가됩니다. 이미 중복 데이터가 있으면 실패하므로, 먼저 아래 "검증에 사용한 조회 쿼리"로 중복을 확인한 뒤 실행하십시오.

```sql
ALTER TABLE registration ADD UNIQUE KEY uk_member_lecture (member_id, lecture_id);
ALTER TABLE scores       ADD UNIQUE KEY uk_member_lecture (member_id, lecture_id);
```

### 코드를 읽을 때 같이 봐야 하는 스키마 사실

| 사실 | 코드에 미치는 영향 |
| :--- | :--- |
| `scores.score` 가 NULL 허용 | MJ-2. 점수 없는 성적 행이 생기고, `rs.getInt()` 가 그것을 0으로 바꿈 |
| `registration`, `scores` 에 복합 UNIQUE 없음 | MN-8. 중복 신청·중복 성적을 DB가 막지 못함 |
| FK가 `NO ACTION` | MJ-6. 참조 중인 강의·회원은 삭제 불가. 지금은 6개 강의 전부 해당 |
| 콜레이션이 `utf8mb4_0900_ai_ci` | MN-7. 아이디 비교가 DB에서는 대소문자를 구분하지 않음 |
| `admin`, `available` 이 `tinyint(1)` | `getBoolean()` 과 `getInt() == 1` 이 둘 다 동작하는 이유. 한쪽으로 통일 권장 |
| `professor` 에 `DEFAULT '미정'` | 자바의 "미정" 하드코딩과 중복 |

### 검증에 사용한 조회 쿼리

같은 확인을 직접 해 보고 싶을 때 쓸 수 있도록 남깁니다. 전부 조회 전용입니다.

```sql
-- available 플래그와 실제 신청 인원이 어긋난 강의 찾기
SELECT l.id, l.lecture_code, l.capacity, COUNT(r.id) AS enrolled, l.available
FROM lectures l
LEFT JOIN registration r ON r.lecture_id = l.id
GROUP BY l.id, l.lecture_code, l.capacity, l.available
HAVING (COUNT(r.id) < l.capacity) <> l.available;

-- 점수가 비어 있는 성적 행 찾기
SELECT * FROM scores WHERE score IS NULL;

-- 중복 수강신청 찾기
SELECT member_id, lecture_id, COUNT(*) FROM registration
GROUP BY member_id, lecture_id HAVING COUNT(*) > 1;

-- 해시되지 않은 비밀번호 찾기
SELECT id, member_id FROM members WHERE password NOT LIKE '$2a$%';
```

---

## 부록 B. 수정 우선순위

| 순서 | 항목 | 예상 작업량 | 효과 |
| :--- | :--- | :--- | :--- |
| 1 | BL-1 `==` → `.equals()` | 1줄 | 수강취소 기능이 살아남 |
| 2 | BL-2 취소 시 PK 전달 | 1줄 | 수강취소가 실제로 동작 |
| 3 | BL-3 `%d` → `%s` | 1줄 | 관리자 전체 조회가 동작 |
| 4 | MJ-1 SELECT에 `lecture_code` 추가 | 1줄 | 강의코드 null 제거 |
| 5 | **현재 어긋난 `available` 2건 바로잡기** | SQL 1줄 | 막혀 있는 CS101, TE102 신청 재개 |
| 6 | MJ-2 성적 조회의 NULL 처리 | 10줄 내외 | 같은 학생이 화면마다 다르게 보이는 문제 해소 |
| 7 | MJ-10 wrapper jar + `db/schema.sql` 커밋 | 15분 | 누구나 clone 후 실행 가능 (부록 A 사용) |
| 8 | MJ-11 DB 비밀번호 교체 | 5분 | 유출된 자격증명 무효화 |
| 9 | MN-8 UNIQUE 제약 2건 추가 | SQL 2줄 | 중복 신청·중복 성적을 DB가 차단 |
| 10 | 나머지 Major | 별도 논의 | 구조 개선 |

1~4번은 **합쳐서 4줄**입니다. 이것만 고쳐도 "동작하지 않는 기능이 없는 상태"가 됩니다.

5번은 데이터 정리입니다. 아래 한 줄로 현재 어긋난 2건이 맞춰집니다. 다만 MJ-3 을 고치지 않으면 같은 일이 다시 생깁니다.

```sql
UPDATE lectures l
SET l.available = ((SELECT COUNT(*) FROM registration r WHERE r.lecture_id = l.id) < l.capacity);
```

---

*이 문서는 코드, 커밋 이력, 그리고 `project_team1` DB의 스키마와 데이터를 실제로 조회해 작성했습니다. DB 검증은 조회 쿼리만 사용했으며 데이터를 변경하지 않았습니다. 남은 "확인 필요" 항목은 2장에 정리되어 있습니다.*
