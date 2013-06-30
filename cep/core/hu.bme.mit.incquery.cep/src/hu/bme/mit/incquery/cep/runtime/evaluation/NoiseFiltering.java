package hu.bme.mit.incquery.cep.runtime.evaluation;

public enum NoiseFiltering {
	/**
	 * 
	 * Consider the example ordered pattern: ABC. And the event stream: A, B, C,
	 * A, B, A, B, X, C, A, B, C.
	 * 
	 * OFF : No noise filtering. 3 ABC patterns are recognized via the Chroncile
	 * strategy.
	 * 
	 * NORMAL : Token creation in the init state allowed at any time, however,
	 * the SM gets reset if an event is observed which none of the guards is
	 * typed with. E.g: the first three events trigger one recognized ABC
	 * pattern; after A, B, A, B there are 2 tokens in the AB state, but after X
	 * arrives, the SM is reset; no activation on C; ABC gets recognized.
	 * 
	 * 
	 * STRICT : Token creation in the init state is allowed only in three cases:
	 * -on the initialization phase (step 0, that is)
	 * -on SM reset
	 * -on observed pattern
	 * E.g. ABC gets recognized, a token is placed in the init state; A arrives, no 
	 * init token creation; B arrives, no init token creation; A arrives: reset, an
	 * init token is created; B, X, C do not enable a transition; ABC gets recognized.
	 */
	OFF, NORMAL, STRICT
}
