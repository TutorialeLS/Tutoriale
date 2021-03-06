package pl.javastart.controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pl.javastart.model.Entry;
import pl.javastart.producers.decorators.Printer;
import pl.javastart.repository.EntryRepository;
import pl.javastart.util.FileService;

@Controller
public class LinguController {
	private static final int UNDEFINED = -1;
	private static final int ADD_ENTRY = 0;
	private static final int TEST = 1;
	private static final int CLOSE_APP = 2;

	private EntryRepository entryRepository;
	private FileService fileService;
	private Scanner scanner;
	private Printer printer;

	@Autowired
	public LinguController(EntryRepository entryRepository, FileService fileService, Scanner scanner,
			Printer printer) {
		this.entryRepository = entryRepository;
		this.fileService = fileService;
		this.scanner = scanner;
		this.printer = printer;
	}

	public void mainLoop() {
		printer.println("Witaj w aplikacji LinguApp");
		int option = UNDEFINED;
		while (option != CLOSE_APP) {
			printMenu();
			option = chooseOption();
			executeOption(option);
		}
	}

	private void executeOption(int option) {
		switch (option) {
		case ADD_ENTRY:
			addEntry();
			break;
		case TEST:
			test();
			break;
		case CLOSE_APP:
			close();
			break;
		default:
			printer.println("Opcja niezdefiniowana");
		}
	}

	private void test() {
		if (entryRepository.isEmpty()) {
			printer.println("Dodaj przynajmniej jedną frazę do bazy.");
			return;
		}
		final int testSize = entryRepository.size() > 10 ? 10 : entryRepository.size();
		Set<Entry> randomEntries = entryRepository.getRandomEntries(testSize);
		int score = 0;
		for (Entry entry : randomEntries) {
			System.out.printf("Podaj tłumaczenie dla :\"%s\"\n", entry.getOriginal());
			String translation = scanner.nextLine();
			if (entry.getTranslation().equalsIgnoreCase(translation)) {
				printer.println("Odpowiedź poprawna");
				score++;
			} else {
				printer.println("Odpowiedź niepoprawna - " + entry.getTranslation());
			}
		}
		System.out.printf("Twój wynik: %d/%d\n", score, testSize);
	}

	private void addEntry() {
		printer.println("Podaj oryginalną frazę");
		String original = scanner.nextLine();
		printer.println("Podaj tłumaczenie");
		String translation = scanner.nextLine();
		Entry entry = new Entry(original, translation);
		entryRepository.add(entry);
	}

	private void close() {
		try {
			fileService.saveEntries(entryRepository.getAll());
			printer.println("Zapisano stan aplikacji");
		} catch (IOException e) {
			printer.println("Nie udało się zapisać zmian");
		}
		printer.println("Bye Bye!");
	}

	private void printMenu() {
		printer.println("Wybierz opcję:");
		printer.println("0 - Dodaj frazę");
		printer.println("1 - Test");
		printer.println("2 - Koniec programu");
	}

	private int chooseOption() {
		int option;
		try {
			option = scanner.nextInt();
		} catch (InputMismatchException e) {
			option = UNDEFINED;
		} finally {
			scanner.nextLine();
		}
		if (option > UNDEFINED && option <= CLOSE_APP)
			return option;
		else
			return UNDEFINED;
	}

}