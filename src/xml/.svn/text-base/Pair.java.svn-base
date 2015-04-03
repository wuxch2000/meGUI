package xml;

public class Pair<T, V> {
	private T first;

	// @Override
	// public boolean equals(Object arg0) {
	// Pair<T, V> other = (Pair<T, V>) arg0;
	// return (this.first.equals(other.first))
	// && (this.second.equals(other.second));
	// }

	private V second;

	public Pair(T first, V v) {
		super();
		this.first = first;
		this.second = v;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Pair<T, V> other = (Pair<T, V>) obj;
		if (first == null) {
			if (other.first != null) {
				return false;
			}
		} else if (!first.equals(other.first)) {
			return false;
		}
		if (second == null) {
			if (other.second != null) {
				return false;
			}
		} else if (!second.equals(other.second)) {
			return false;
		}
		return true;
	}

    @Override
    protected Pair<T, V> clone() throws CloneNotSupportedException {
        return new Pair<T, V>(first,second);
    }

    public T getFirst() {
		return first;
	}

	public V getSecond() {
		return second;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public void setSecond(V second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return "Pair [first=\"" + first + "\", second=\"" + second + "\"]";
	}
}
