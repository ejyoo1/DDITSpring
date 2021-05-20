package ejyoo.exception;

public class NotEnoughDataException extends Exception{
	public NotEnoughDataException () {
		super("데이터가 적절치 않습니다. 확인해주세요");
	}
}
