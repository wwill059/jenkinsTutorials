package com.revature.dao;

import java.util.List;

import com.revature.pojos.Bear;

public interface BearDao {

	public Bear getBear(int id);
	public List<Bear> getAllBears();
	public Bear putBear(Bear bear);
	public void updateBear(Bear bear);
	public void deleteBear(Bear bear);
	public void feedBear(int bearId, double fat);
}
