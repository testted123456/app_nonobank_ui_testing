package com.nonobank.apps.driver.ios;

import org.openqa.selenium.WebElement;
import com.google.common.base.Function;
import io.appium.java_client.ios.IOSDriver;

public interface ExpectedCondition<T> extends Function<IOSDriver<WebElement>, T> {
}
