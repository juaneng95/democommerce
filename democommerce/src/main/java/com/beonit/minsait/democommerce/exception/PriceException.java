package com.beonit.minsait.democommerce.exception;

import lombok.Getter;

import java.io.Serial;

@Getter
public abstract class PriceException extends Exception {

  @Serial private static final long serialVersionUID = 1L;

  private final int code;

  protected PriceException(int code, String message) {
    super(message);
    this.code = code;
  }
}
