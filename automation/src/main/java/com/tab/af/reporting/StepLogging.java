package com.tab.af.reporting;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class StepLogging {

  private Logger log = Logger.getLogger(StepLogging.class);
  private static StepLogging stepLogging;

  private StepLogging() {
    // Singleton
  }

  public static StepLogging logObject() {
    if (stepLogging == null) {
      stepLogging = new StepLogging();
    }
    return stepLogging;
  }

  public void setLogginLevel(String loggingLevel) {
    log.setLevel(Level.toLevel(loggingLevel));

  }

  public void info(String actionDetails, String elementName)

  {
    log.info("Thread: " + Thread.currentThread().getName() + actionDetails + elementName);
  }

  public void warn(String actionDetails, String elementName) {

    log.warn("Thread: " + Thread.currentThread().getName() + actionDetails + elementName);

  }

  public void warn(String message) {

    log.warn("Thread: " + Thread.currentThread().getName() + "message");

  }

  public void error(String actionDetails, String elementName, Exception e) {

    log.error("Thread: " + Thread.currentThread().getName() + actionDetails + elementName, e);

  }

  public void error(String message, Exception e) {

    log.error("Thread: " + Thread.currentThread().getName() + message, e );


  }

  public void fatal(String actionDetails, String elementName, Exception e) {

    log.fatal("Thread: " + Thread.currentThread().getName() + actionDetails + elementName, e);

  }


}
