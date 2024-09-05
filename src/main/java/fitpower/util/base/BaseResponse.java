package fitpower.util.base;

import java.util.List;

public class BaseResponse<T> {

    public boolean isSuccess;
    public boolean isFound;
    public String message;
    public T data;
    public List<String> errors;

    public void Ok(String msg){
        isSuccess=true;
        isFound=true;
        message=msg;
    }

    public void Ok(T genericData, String msg){
        isSuccess=true;
        isFound=true;
        data=genericData;
        message=msg;
    }

    public void BadRequest(String msg){
        isSuccess=false;
        isFound=true;
        message=msg;
    }

    public void NotFound(String msg){
        isSuccess=false;
        isFound=false;
        message=msg;
    }
}
