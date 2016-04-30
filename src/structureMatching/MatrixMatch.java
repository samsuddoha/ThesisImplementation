package structureMatching;

public class MatrixMatch {

	int[][] currentP, historicP;
	int pN, sN;

	public boolean naiveMatch(int[][] currentP, int[][] historicP) {

		this.currentP = currentP;
		this.historicP = historicP;
		pN = currentP.length;
		sN = historicP.length;
		
		int[] permuteIndex = new int[sN];
		for (int i = 0; i < sN; i++) {
			permuteIndex[i] = i;
		}
		do {
			int i;
			for (i = 0; i < pN; i++) {
				int j;
				for (j = 0; j < pN; j++) {
					if (currentP[i][j] != historicP[permuteIndex[i]][permuteIndex[j]]) {
						break;
					}
				}
				if (j != pN) {
					break;
				}
			}
			if (i == pN) {
				return true;
			}
		} while ((permuteIndex = nextPermutation(permuteIndex)) != null);
		return false;
	}

	private int[] nextPermutation(final int[] c) {
		int first = getFirst(c);
		if (first == -1)
			return null;
		int toSwap = c.length - 1;
		while (c[first] >= (c[toSwap]))
			--toSwap;
		swap(c, first++, toSwap);
		toSwap = c.length - 1;
		while (first < toSwap)
			swap(c, first++, toSwap--);
		return c;
	}

	private int getFirst(final int[] c) {
		for (int i = c.length - 2; i >= 0; --i)
			if (c[i] < c[i + 1])
				return i;
		return -1;
	}

	private void swap(final int[] c, final int i, final int j) {
		final int tmp = c[i];
		c[i] = c[j];
		c[j] = tmp;
	}

}
