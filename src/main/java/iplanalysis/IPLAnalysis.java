package iplanalysis;

import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;

import csvbuilder.CSVBuilderException;
import model.IPLDAO;

public class IPLAnalysis<E> {

	private List<IPLDAO> iplDaoList = null;

	public IPLAnalysis(Class<E> classType, String csvFilePath) throws CSVBuilderException {
		IPLDataLoader iplDataLoader = new IPLDataLoader();
		this.iplDaoList = iplDataLoader.loadIPLData(classType, csvFilePath, ',');
	}

	private void sort(Comparator<IPLDAO> iplComparator) {
		for (int i = 0; i < iplDaoList.size() - 1; i++) {
			for (int j = 0; j < iplDaoList.size() - i - 1; j++) {
				IPLDAO ipl1 = iplDaoList.get(j);
				IPLDAO ipl2 = iplDaoList.get(j + 1);
				if (iplComparator.compare(ipl1, ipl2) > 0) {
					iplDaoList.set(j, ipl2);
					iplDaoList.set(j + 1, ipl1);
				}
			}
		}
	}

	public String getAverageWiseSortedIPLMostRunsData() throws CSVBuilderException {
		if (iplDaoList == null || iplDaoList.size() == 0) {
			throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
		}
		Comparator<IPLDAO> iplComparator = Comparator.comparing(ipl -> ipl.average, Comparator.reverseOrder());
		this.sort(iplComparator);
		String sortedMostRuns = new Gson().toJson(iplDaoList);
		return sortedMostRuns;

	}
	
	public String getStrikeRatesWiseSortedIPLMostRunsData() throws CSVBuilderException{
		if (iplDaoList == null || iplDaoList.size() == 0) {
			throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
		}
		Comparator<IPLDAO> iplComparator = Comparator.comparing(ipl -> ipl.strikeRate, Comparator.reverseOrder());
		this.sort(iplComparator);
		String sortedMostRuns = new Gson().toJson(iplDaoList);
		return sortedMostRuns;

	}

}
