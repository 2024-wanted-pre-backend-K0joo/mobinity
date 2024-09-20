package wanted.mobinity.global.error.exception;

import wanted.mobinity.global.error.ErrorCode;

public class InvalidPasswordException extends BusinessException{
    public InvalidPasswordException(ErrorCode errorCode){
        super(errorCode);
    }
}
