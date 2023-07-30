package com.hello2chandan.aws.lambda.repo;

public interface CurdRepo<T,ID> {	
	ID add(T item);
	T get(ID id);
	T update(T item);
	ID delete(ID id);
}
