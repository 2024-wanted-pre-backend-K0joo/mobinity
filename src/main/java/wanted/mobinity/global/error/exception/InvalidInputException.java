package wanted.mobinity.global.error.exception;

import wanted.mobinity.global.error.ErrorCode;

public class InvalidInputException extends BusinessException{
    public InvalidInputException(){
        super(ErrorCode.INPUT_VALUE_INVALID);
    }
}
