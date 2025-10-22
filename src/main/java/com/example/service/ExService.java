package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExService {

	private static final Logger log = LoggerFactory.getLogger(ExService.class);

//	public String sayHello(String hi) {
//		String msg = hi + " 좋은날";
//		System.out.println(msg);
//		log.info(msg);
//		log.warn(msg);
//		return msg;
//	}

	public String ex321() {

		int number = 1;
		String result = "";

		if (number == 1) {
			result = "if 블록입니다.";
			System.out.println(result);
			log.info(result);
		} else if (number == 2) {
			result = "else if 블록입니다.";
			System.out.println(result);
		} else {
			result = "else 블록입니다.";
			System.out.println("else 블록입니다.");
			log.info(result);
		}
		return result;
	}

	public String ex322() {

		int[] array = { 1, 2, 3, 4, 5 };
		String result = "";
		for (int i = 0; i < array.length; i++)
			result += array[i];
		log.info(result);
		return result;
	}

	public String ex323() {
		String result = "";
		int[] array = { 1, 2, 3, 4, 5 };
		int i = 0;

		while (i < array.length) {
			result += array[i];
			log.info(result);
			i++;
		}
		return result;
	}

	public interface Car {
		public String getColor();
	}

	public class Sonata implements Car {
		public Sonata() {
			log.info("Sonata 출고");
		}

		@Override
		public String getColor() {
			return "red Sonata";
		}
	}

	public class K5 implements Car {
		public K5() {
			log.info("k5 출고");
		}

		@Override
		public String getColor() {
			return "blue K5";
		}
	}

	public String ex324() {
		Car car1 = new Sonata();
		String re1 = car1.getColor();
		Car car2 = new K5();
		String re2 = car2.getColor();
		String result = re1 + "<br>" + re2 + "<br>" + "차 두대 출고";
		return result;
	}

	public String ex325() {
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);

		log.info("리스트 전체: {}", list);

		return list.toString();
	}

	public String ex326() {

		List<String> list = new ArrayList<>();

		list.add("public");
		list.add("static");
		list.add("void");

		for (int i = 0; i < list.size(); i++) {
			log.info(list.get(i));
		}
		list.remove(1);

		int voidIndex = list.indexOf("void");

		log.info("void의 index = {}", voidIndex);
		return String.valueOf(voidIndex);
	}

	public String ex327() {

		String str1 = new String("is same?");
		String str2 = new String("is same?");

		boolean result = str1 == str2;
		return String.valueOf(result);
	}

	public String ex328() {

		String str1 = new String("is same?");
		String str2 = new String("is same?");

		boolean result = (str1.equals(str2));
		return String.valueOf(result);
	}

	public String ex331() {
		List<String> list = new ArrayList<>();

		list.add("public");
		list.add("static");
		list.add("void");

		list.sort(new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.compareTo(str2);
			}
		});
		list.sort((Comparator<String>) (str1, str2) -> str1.compareTo(str2));
		return null;
	}

	public String ex332() {

		List<String> list = new ArrayList<>();

		list.add("public");
		list.add("static");
		list.add("void");

		list.stream().forEach(str -> System.out.println(str));

		return null;
	}

	public String ex333() {
		Integer[] integerArray = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> list = Arrays.asList(integerArray);

		List<Integer> evenList = new ArrayList<>();

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {
			Integer number = list.get(i);
			if (number % 2 == 0) {
				evenList.add(number);
			}
		}

		for (int i = 0; i < evenList.size(); i++) {
			result.append(evenList.get(i)).append("<br>");
		}
		String finalresult = result.toString();
		return finalresult;
	}

	public String ex334() {

		Integer[] integerArray = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> list = Arrays.asList(integerArray);

		List<Integer> evenList = list.stream().filter(value -> value % 2 == 0).collect(Collectors.toList());

		evenList.stream().forEach(value -> log.info(String.valueOf(value)));
		return String.valueOf(evenList);
	}

	public String ex335() {

		Integer[] integerArray = new Integer[] { 1, 2, 3, 4, 5 };
		List<Integer> list = Arrays.asList(integerArray);
		list.stream().forEach(value -> log.info("{}", value));
		return String.valueOf(list);
	}

	public String ex336() {

		Integer[] integerArray = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> list = Arrays.asList(integerArray);
		List<?> evenList = list.stream().filter(value -> value % 2 == 0).collect(Collectors.toList());
		evenList.stream().forEach(value -> log.info("{}", value));
		return evenList.toString();
	}

	public String ex337() {

		Integer[] integerArray = new Integer[] { 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
		List<Integer> list = Arrays.asList(integerArray);
		List<Integer> distinctList = list.stream().distinct().toList();
		distinctList.stream().forEach(value -> log.info("{}", value));
		return distinctList.toString();
	}

	public String ex338() {

		String[] lowercaseArray = new String[] { "public", "static", "void" };
		List<String> lowercaseList = Arrays.asList(lowercaseArray);
		List<String> uppercaseList = lowercaseList.stream().map(value -> value.toUpperCase()).toList();
		uppercaseList.stream().forEach(value -> log.info("{}", value));
		return String.valueOf(uppercaseList);
	}

	public String ex339() {
		class StringClass {
			private String getSomeString() {
				return "";
			}
		}
		StringClass inner = new StringClass();
		String isThisNull = inner.getSomeString();

		if (null != isThisNull) {
			log.info(isThisNull.toUpperCase());
		}

		return isThisNull;
	}

	public String ex3310() {
		class StringClass {
			private String getSomeString() {
				return "";
			}
		}
		StringClass inner = new StringClass();
		String isThisNull = inner.getSomeString();

		log.info(isThisNull.toUpperCase());
		return isThisNull;
	}

	public Optional<String> ex3311() {
		class StringClass {
			private Optional<String> getSomeString() {
				return Optional.empty();
			}
		}
		StringClass inner = new StringClass();
		Optional<String> isThisNull = inner.getSomeString();

		isThisNull.ifPresent(str -> log.info(str.toUpperCase()));
		return isThisNull;
	}

	public Optional<String> ex3312() {
		class StringClass {
			private Optional<String> getSomeString() {
				return Optional.ofNullable("public static void");
			}
		}
		StringClass inner = new StringClass();
		Optional<String> isThisNull = inner.getSomeString();

		isThisNull.ifPresent(str -> log.info(str.toUpperCase()));
		return isThisNull;
	}

	public String ex521() {
		return "Hello";
	}

	public String ex522() {
		return "인사하기";
	}

	public String ex523() {
		return "Hello <strong>Backend</strong>";
	}

}
