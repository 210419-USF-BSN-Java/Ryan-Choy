package com.revature.shop.services.dao;

import java.util.List;

public interface GenericShopDao<T> {
	public T add(T t);
	public T getById(Integer id);
	public List<T> getAll();
	public Integer update(T t);
	public Integer delete(T t);

}
