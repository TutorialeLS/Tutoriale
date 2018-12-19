package pl.javastart.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.javastart.model.Entry;
import pl.javastart.util.FileService;

@Repository
public class EntryRepository {
	private List<Entry> entries;
	private FileService fileService;

	@Autowired
	public EntryRepository(FileService fileService) {
		this.fileService = fileService;
		try {
			this.entries = fileService.readAllFile();
		} catch (IOException e) {
			entries = new ArrayList<>();
		}
	}

	public List<Entry> getAll() {
		return entries;
	}

	public Set<Entry> getRandomEntries(int number) {
		Random random = new Random();
		Set<Entry> randomEntries = new HashSet<>();
		while (randomEntries.size() < number && randomEntries.size() < entries.size()) {
			randomEntries.add(entries.get(random.nextInt(entries.size())));
		}
		return randomEntries;
	}

	public void add(Entry entry) {
		entries.add(entry);
	}

	public int size() {
		return entries.size();
	}

	public boolean isEmpty() {
		return entries.isEmpty();
	}
}