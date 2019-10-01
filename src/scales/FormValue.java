package scales;

import java.util.Optional;

public interface FormValue<E extends Enum> {

	int getFormValue();

	int toFormValue(E enumValue);

	Optional<E> toEnumValue(int formValue);
}
