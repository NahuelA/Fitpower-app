package fitpower.service.interfaces.comunication;

import fitpower.model.user.Admin;
import fitpower.model.user.Customer;
import fitpower.model.user.Nutritionist;
import fitpower.model.user.Trainer;

public interface IMenuService{

    public void admin(Admin admin);
    public void trainer(Trainer trainer);
    public void nutritionist(Nutritionist nutritionist);
    public void customerProfiles();
    public void customerHistory();
    public void customer();
    public void login();
}
