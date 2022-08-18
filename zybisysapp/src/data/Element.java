package data;

import org.openqa.selenium.By;

public class Element {
	private String value;
	private String replaceValue;
	private ElementType locatorType;
	public String name;
	public By locator;

	public Element(String value, ElementType locatorType, String elementName) {
		this.value = value;
		this.replaceValue = value;
		this.locatorType = locatorType;
		this.name = elementName;
		setValue();

	}

	public Element replace(String replacer) {
		this.value = String.format(replaceValue, replacer);
		setValue();
		return this;
	}

	private void setValue() {
		switch (locatorType) {
		case XPATH:
			locator = By.xpath(value);
			break;
		case ID:
			locator = By.id(value);
			break;
		}
	}
}