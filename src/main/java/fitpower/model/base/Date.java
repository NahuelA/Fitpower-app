package fitpower.model.base;

import java.time.LocalDateTime;

public class Date {

    private LocalDateTime registrationDate;
    private LocalDateTime updateDate;

    public LocalDateTime getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(LocalDateTime date) {
        this.registrationDate = date;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
