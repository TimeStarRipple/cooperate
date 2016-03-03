package com.lims.service;

import java.util.List;

import com.lims.entity.Consumable;

public interface ConsumableService {

	public List<Consumable> listConsumableByPage(String filterCondition,
			int courrentPageNum, int courrentPageSize);

	public int getPageCount(String filterCondition);

}
