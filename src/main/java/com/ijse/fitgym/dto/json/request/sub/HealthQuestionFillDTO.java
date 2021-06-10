package com.ijse.fitgym.dto.json.request.sub;

public class HealthQuestionFillDTO {
    private long questionId;
    private boolean answer;

    public HealthQuestionFillDTO() {
    }

    public HealthQuestionFillDTO(long questionId, boolean answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "HealthQuestionFillDTO{" +
                "questionId=" + questionId +
                ", answer=" + answer +
                '}';
    }
}
