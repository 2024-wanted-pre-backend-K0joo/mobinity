package wanted.mobinity.global.error.exception;

import wanted.mobinity.global.error.ErrorCode;

public class EntityAlreadyExistException extends BusinessException{
    public EntityAlreadyExistException(ErrorCode errorCode){
        super(errorCode);
    }
}
