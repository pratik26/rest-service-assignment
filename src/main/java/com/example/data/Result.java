package com.example.data;

import java.util.List;

public class Result {

    private final List<Long> primes;
    private final boolean success;
    private final String message;
    
	public Result(boolean success, String message, List<Long> primes) {
		this.primes = primes;
		this.success = success;
		this.message = message;
	}

	public List<Long> getPrimes() {
		return primes;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((primes == null) ? 0 : primes.hashCode());
		result = prime * result + (success ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (primes == null) {
			if (other.primes != null)
				return false;
		} else if (!primes.equals(other.primes))
			return false;
		if (success != other.success)
			return false;
		return true;
	}

    
}
