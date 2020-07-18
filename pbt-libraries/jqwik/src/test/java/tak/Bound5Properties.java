package tak;

import net.jqwik.api.*;

@Label("Bound 5")
class Bound5Properties {

	@Property
	boolean failing(@ForAll int aNumber) {
		return false;
	}

}
