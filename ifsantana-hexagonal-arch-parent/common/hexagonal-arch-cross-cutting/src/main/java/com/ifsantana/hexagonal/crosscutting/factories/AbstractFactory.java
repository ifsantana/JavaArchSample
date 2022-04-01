package com.ifsantana.hexagonal.crosscutting.factories;

public interface AbstractFactory<T, TParameter> {
  T create(TParameter param);
}
