package ejyoo.exception;

public class NotEnoughResultException extends Exception{
	public NotEnoughResultException() {
		super("결과가 적절치 않습니다. 확인해주세요.");
	}
}
