package com.ifsantana.hexagonal.crosscutting.bus;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

public class QueryHandler<TResquest, TResponse> extends ApplicationEvent implements
    ResolvableTypeProvider {

  public QueryHandler(TResquest source) {
    super(source);
  }

  @Override
  public ResolvableType getResolvableType() {
    return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getSource()));
  }
}
