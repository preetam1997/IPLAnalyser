package iplanalysis;

import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;

import csvbuilder.CSVBuilderException;
import model.IPLDAO;

public class IPLAnalysis<E> {

	private List<IPLDAO> iplDaoList = null;
	public IPLDataLoader iplDataLoader = null;

	public IPLAnalysis(Class<E> classType, String csvFilePath) throws CSVBuilderException {
		iplDataLoader = new IPLDataLoader();
		this.iplDaoList = iplDataLoader.loadIPLData(classType, csvFilePath, ',');
	}

	public IPLAnalysis() {
		iplDataLoader = new IPLDataLoader();
	}

	private void sort(Comparator<IPLDAO> iplComparator, List<IPLDAO> daoList) {
		for (int i = 0; i < daoList.size() - 1; i++) {
			for (int j = 0; j < daoList.size() - i - 1; j++) {
				IPLDAO ipl1 = daoList.get(j);
				IPLDAO ipl2 = daoList.get(j + 1);
				if (iplComparator.compare(ipl1, ipl2) > 0) {
					daoList.set(j, ipl2);
					daoList.set(j + 1, ipl1);
				}
			}
		}
	}

	// UC1
	public String getAverageWiseSortedIPLMostRunsData() throws CSVBuilderException {
		if (iplDaoList == null || iplDaoList.size() == 0) {
			throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
		}
		Comparator<IPLDAO> iplComparator = Comparator.comparing(ipl -> ipl.average, Comparator.reverseOrder());
		this.sort(iplComparator, iplDaoList);
		String sortedMostRuns = new Gson().toJson(iplDaoList);
		return sortedMostRuns;

	}

	// UC2
	public String getStrikeRatesWiseSortedIPLMostRunsData() throws CSVBuilderException {
		if (iplDaoList == null || iplDaoList.size() == 0) {
			throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
		}
		Comparator<IPLDAO> iplComparator = Comparator.comparing(ipl -> ipl.strikeRate, Comparator.reverseOrder());
		this.sort(iplComparator, iplDaoList);
		String sortedMostRuns = new Gson().toJson(iplDaoList);
		return sortedMostRuns;

	}

	// UC3
	public String getFoursandSixesWiseSortedIPLMostRunsData() throws CSVBuilderException {
		if (iplDaoList == null || iplDaoList.size() == 0) {
			throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
		}
		Comparator<IPLDAO> iplComparator = Comparator.comparing(IPLDAO::getSixes, Comparator.reverseOrder())
				.thenComparing(cricketDAO -> cricketDAO.fours, Comparator.reverseOrder());
		this.sort(iplComparator, iplDaoList);
		String sortedMostRuns = new Gson().toJson(iplDaoList);
		return sortedMostRuns;

	}

	// UC4
	public String getStrinkeRateFoursandSixesWiseSortedIPLMostRunsData() throws CSVBuilderException {
		if (iplDaoList == null || iplDaoList.size() == 0) {
			throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
		}
		Comparator<IPLDAO> iplComparator = Comparator.comparing(IPLDAO::getStrikeRate, Comparator.reverseOrder())
				.thenComparing(cricketDAO -> cricketDAO.sixes + cricketDAO.fours, Comparator.reverseOrder());
		this.sort(iplComparator, iplDaoList);
		String sortedMostRuns = new Gson().toJson(iplDaoList);
		return sortedMostRuns;

	}

	// UC5
	public String getAverageandStrikeRateWiseSortedIPLMostRunsData() throws CSVBuilderException {
		if (iplDaoList == null || iplDaoList.size() == 0) {
			throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
		}
		Comparator<IPLDAO> iplComparator = Comparator.comparing(IPLDAO::getAverage, Comparator.reverseOrder())
				.thenComparing(cricketDAO -> cricketDAO.strikeRate, Comparator.reverseOrder());
		this.sort(iplComparator, iplDaoList);
		String sortedMostRuns = new Gson().toJson(iplDaoList);
		return sortedMostRuns;

	}

	// UC6
	public String getMaximumRunsandBestAverageWiseSortedIPLMostRunsData() throws CSVBuilderException {
		if (iplDaoList == null || iplDaoList.size() == 0) {
			throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
		}
		Comparator<IPLDAO> iplComparator = Comparator.comparing(IPLDAO::getHighScore, Comparator.reverseOrder())
				.thenComparing(cricketDAO -> cricketDAO.average, Comparator.reverseOrder());
		this.sort(iplComparator, iplDaoList);
		String sortedMostRuns = new Gson().toJson(iplDaoList);
		return sortedMostRuns;

	}

	// UC7
	public String getBowlingAverageWiseSortedIPLMostWicketsData() throws CSVBuilderException {
		if (iplDaoList == null || iplDaoList.size() == 0) {
			throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
		}
		Comparator<IPLDAO> iplComparator = Comparator.comparing(cricketDAO -> cricketDAO.averageBowler,
				Comparator.reverseOrder());
		this.sort(iplComparator, iplDaoList);
		String sortedMostWickets = new Gson().toJson(iplDaoList);
		return sortedMostWickets;

	}

	// UC8
	public String getBowlingStrikeRateWiseSortedIPLMostWicketsData() throws CSVBuilderException {
		if (iplDaoList == null || iplDaoList.size() == 0) {
			throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
		}
		Comparator<IPLDAO> iplComparator = Comparator.comparing(cricketDAO -> cricketDAO.strikeRateBowler,
				Comparator.reverseOrder());
		this.sort(iplComparator, iplDaoList);
		String sortedMostWickets = new Gson().toJson(iplDaoList);
		return sortedMostWickets;

	}

	// UC9
	public String getBowlingEconomyRateWiseSortedIPLMostWicketsData() throws CSVBuilderException {
		if (iplDaoList == null || iplDaoList.size() == 0) {
			throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
		}
		Comparator<IPLDAO> iplComparator = Comparator.comparing(cricketDAO -> cricketDAO.economy,
				Comparator.reverseOrder());
		this.sort(iplComparator, iplDaoList);
		String sortedMostWickets = new Gson().toJson(iplDaoList);
		return sortedMostWickets;

	}

	// UC10
	public String getStrikeRateWith4Wand5WWiseSortedIPLMostWicketsData() throws CSVBuilderException {
		if (iplDaoList == null || iplDaoList.size() == 0) {
			throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
		}
		Comparator<IPLDAO> iplComparator = Comparator.comparing(IPLDAO::getStrikeRateBowler, Comparator.reverseOrder())
				.thenComparing(cricketDAO -> cricketDAO.fourWickets + cricketDAO.fiveWickets,
						Comparator.reverseOrder());
		this.sort(iplComparator, iplDaoList);
		String sortedMostWickets = new Gson().toJson(iplDaoList);
		return sortedMostWickets;

	}

	// UC11
	public String getBowlingAverageWithStrikeRateSortedIPLMostWicketsData() throws CSVBuilderException {
		if (iplDaoList == null || iplDaoList.size() == 0) {
			throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
		}
		Comparator<IPLDAO> iplComparator = Comparator.comparing(IPLDAO::getAverageBowler, Comparator.reverseOrder())
				.thenComparing(cricketDAO -> cricketDAO.strikeRateBowler, Comparator.reverseOrder());
		this.sort(iplComparator, iplDaoList);
		String sortedMostWickets = new Gson().toJson(iplDaoList);
		return sortedMostWickets;

	}

	// UC12
	public String getWicketsandBowlingAverageWiseSortedIPLMostWicketsData() throws CSVBuilderException {
		if (iplDaoList == null || iplDaoList.size() == 0) {
			throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
		}
		Comparator<IPLDAO> iplComparator = Comparator.comparing(IPLDAO::getWickets, Comparator.reverseOrder())
				.thenComparing(cricketDAO -> cricketDAO.averageBowler, Comparator.reverseOrder());
		this.sort(iplComparator, iplDaoList);
		String sortedMostWickets = new Gson().toJson(iplDaoList);
		return sortedMostWickets;

	}

	// UC13
	public String getBattingandBowlingAverageWiseSortedIPLMostData(Class<E> classType1, Class<E> classType2,
			String csvFilePath1, String CsvFilePath2) throws CSVBuilderException {
		iplDataLoader.loadIPLData(classType1, csvFilePath1, ',');
		iplDataLoader.loadIPLData(classType2, CsvFilePath2, ',');
		List<IPLDAO> iplMergedList = iplDataLoader.MergeIPLData();
		Comparator<IPLDAO> iplComparator = Comparator.comparing(IPLDAO::getAverage, Comparator.reverseOrder())
				.thenComparing(cricketDAO -> cricketDAO.averageBowler);
		this.sort(iplComparator, iplMergedList);
		String sortedMostWickets = new Gson().toJson(iplMergedList);
		return sortedMostWickets;

	}

	// UC14
	public String getBestAllRounder(Class<E> classType1, Class<E> classType2, String csvFilePath1, String CsvFilePath2)
			throws CSVBuilderException {
		iplDataLoader.loadIPLData(classType1, csvFilePath1, ',');
		iplDataLoader.loadIPLData(classType2, CsvFilePath2, ',');
		List<IPLDAO> iplMergedList = iplDataLoader.MergeIPLData();
		Comparator<IPLDAO> iplComparator = Comparator.comparing(IPLDAO::getHighScore, Comparator.reverseOrder())
				.thenComparing(cricketDAO -> cricketDAO.wickets, Comparator.reverseOrder());
		this.sort(iplComparator, iplMergedList);
		String sortedMostWickets = new Gson().toJson(iplMergedList);
		return sortedMostWickets;

	}
	
	// UC15
		public String getMaxCenturyandbattingAvgWiseSortedIPLMostWicketsData() throws CSVBuilderException {
			if (iplDaoList == null || iplDaoList.size() == 0) {
				throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
			}
			Comparator<IPLDAO> iplComparator = Comparator.comparing(IPLDAO::getWickets, Comparator.reverseOrder())
					.thenComparing(cricketDAO -> cricketDAO.averageBowler, Comparator.reverseOrder());
			this.sort(iplComparator, iplDaoList);
			String sortedMostWickets = new Gson().toJson(iplDaoList);
			return sortedMostWickets;

		}
}
