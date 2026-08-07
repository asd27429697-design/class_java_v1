package com.oop15;

public class Todo {

    private String content;
    // 참고 - boolean 필드명에 관례상 is를 붙이지 않는다.
    private boolean completed;

    public Todo(String content) {
        this.content = content;
    }

    // getter
    public String getContent() {
        return content;
    }
    // getter - boolean 타입은 관례상 is로 만들어 준다.
    public boolean isCompleted() {
        return completed;
    }

    // setter - 단순히 상태값만 변경하는 메소드는 set 으로 만들어 준다
    // set 에서는 is를 사용하지 않고  set 으로 이름을 만들어 준다.
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void showInfo() {
        String status;
        if (completed) {
            status = "완료";
        } else {
            status = "미완료";
        }
        System.out.println("할 일 내용: " + content + " " + status);
    }
}
