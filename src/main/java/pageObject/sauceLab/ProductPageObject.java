package pageObject.sauceLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.sauceLab.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	protected ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String itemName) {
		waitForElementClickable(driver, ProductPageUI.SELECT_ITEM_IN_DROP_DOWN);
		selectItemInDefautlDropDown(driver, ProductPageUI.SELECT_ITEM_IN_DROP_DOWN, itemName);

	}
	
	public boolean isProductNameSortByAscendingLamda(){
		List<WebElement>elementList = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);
		List<String> names = elementList.stream().map(n -> n.getText()).collect(Collectors.toList());
		List<String>sortedNames = new ArrayList<String>(names);
		Collections.sort(sortedNames);
		return names.equals(sortedNames);
	}
	
	public boolean isProductNameSortByDescendingLamda(){
		List<WebElement>elementList = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);
		List<String> names = elementList.stream().map(n -> n.getText()).collect(Collectors.toList());
		List<String>sortedNames = new ArrayList<String>(names);
		Collections.sort(sortedNames);
		Collections.reverse(sortedNames);
		return names.equals(sortedNames);
	}

	public boolean isProductNameSortByAscending() {
		// Khai bao ra 1 Array list de chua cac Product Name tren UI
		ArrayList<String> productNameList = new ArrayList<>();

		// Lay ra het tat ca text cua Product Name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);

		// Dung vong lap de getText va add vao Array List tren
		for (WebElement productName : productNameText) {
			productNameList.add(productName.getText());
			System.out.println("Product Name tren UI:" + productName.getText());
		}

		// Tao ra 1 array list moi de sort du lieu trong Array list cu xem co dung khong
		ArrayList<String> productSortList = new ArrayList<>();
		for (String product : productNameList) {
			productSortList.add(product);
			System.out.println("Product Name sau khi sort ASC:" + product);
		}

		// Sort productSortList
		Collections.sort(productSortList);
		for (String product : productSortList) {
			System.out.println("Product Name sau khi sort ASC:" + product);
		}

		// So sanh 2 List bang nhau

		return productSortList.equals(productNameList);
	}

	public boolean isProductNameSortByDescending() {
		// Khai bao ra 1 Array list de chua cac Product Name tren UI
		ArrayList<String> productNameList = new ArrayList<>();

		// Lay ra het tat ca text cua Product Name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);

		// Dung vong lap de getText va add vao Array List tren
		for (WebElement productName : productNameText) {
			productNameList.add(productName.getText());
			System.out.println("Product Name tren UI:" + productName.getText());
		}

		// Tao ra 1 array list moi de sort du lieu trong Array list cu xem co dung khong
		ArrayList<String> productSortList = new ArrayList<>();
		for (String product : productNameList) {
			productSortList.add(product);
		}

		// Sort productSortList
		Collections.sort(productSortList);
		for (String product : productSortList) {
			System.out.println("Product Name sau khi sort ASC:" + product);
		}

		// Reverse productSortList
		Collections.reverse(productSortList);
		for (String product : productSortList) {
			System.out.println("Product Name sau khi sort DESC:" + product);
		}

		// So sanh 2 List bang nhau

		return productSortList.equals(productNameList);
	}

	public boolean isProductPriceSortByAscending() {
		// Khai bao ra 1 Array list de chua cac Product Name tren UI
		ArrayList<Float> productPriceList = new ArrayList<>();

		// Lay ra het tat ca text cua Product Name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);

		// Dung vong lap de getText va add vao Array List tren
		for (WebElement productPrice : productPriceText) {
			productPriceList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
			System.out.println("Product Preice tren UI:" + productPrice.getText());
		}

		// Tao ra 1 array list moi de sort du lieu trong Array list cu xem co dung khong
		ArrayList<Float> productPriceSortList = new ArrayList<>();
		for (Float productPrice : productPriceList) {
			productPriceSortList.add(productPrice);
		}

		// Sort productSortList
		Collections.sort(productPriceSortList);
		for (Float productPrice : productPriceSortList) {
			System.out.println("Product Price sau khi sort ASC:" + productPrice);
		}

		// So sanh 2 List bang nhau

		return productPriceSortList.equals(productPriceList);
	}

	public boolean isProductPriceSortByDescending() {
		// Khai bao ra 1 Array list de chua cac Product Name tren UI
				ArrayList<Float> productPriceList = new ArrayList<>();

				// Lay ra het tat ca text cua Product Name
				List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);

				// Dung vong lap de getText va add vao Array List tren
				for (WebElement productPrice : productPriceText) {
					productPriceList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
					System.out.println("Product Preice tren UI:" + productPrice.getText());
				}

				// Tao ra 1 array list moi de sort du lieu trong Array list cu xem co dung khong
				ArrayList<Float> productPriceSortList = new ArrayList<>();
				for (Float productPrice : productPriceList) {
					productPriceSortList.add(productPrice);
				}

				// Sort productSortList
				Collections.sort(productPriceSortList);
				for (Float productPrice : productPriceSortList) {
					System.out.println("Product Price sau khi sort ASC:" + productPrice);
				}
				
				// Reverse productSortList
				Collections.reverse(productPriceSortList);
				for (Float productPrice : productPriceSortList) {
					System.out.println("Product Price sau khi sort DESC:" + productPrice);
				}

				// So sanh 2 List bang nhau

				return productPriceSortList.equals(productPriceList);
			}

}
