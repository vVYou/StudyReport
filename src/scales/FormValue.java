package scales;

public interface FormValue<E extends Enum> {

	int getFormValue();

	int toFormValue(E enumValue);
}
