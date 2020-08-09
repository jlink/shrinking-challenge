package challenges;

import java.util.*;

public class ShrinkingValues {

	int evaluations;
	String seed;
	Map<String, String> shrunk;

	private void setEvaluations(int evaluations) {
		this.evaluations = evaluations;
	}

	private void setSeed(String seed) {
		this.seed = seed;
	}

	private void setShrunk(Map<String, String> shrunk) {
		this.shrunk = shrunk;
	}

	public int getEvaluations() {
		return evaluations;
	}

	public String getSeed() {
		return seed;
	}

	public Map<String, String> getShrunk() {
		return shrunk;
	}

	ShrinkingValues(int evaluations, String seed, Map<String, String> shrunk) {
		this.evaluations = evaluations;
		this.seed = seed;
		this.shrunk = shrunk;
	}
}
