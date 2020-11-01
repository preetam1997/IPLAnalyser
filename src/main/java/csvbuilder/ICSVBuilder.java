package csvbuilder;

import java.io.Reader; 
import java.util.Iterator;
import java.util.List;


@SuppressWarnings("rawtypes")
public interface ICSVBuilder<E> {

	public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass, char delimiter) throws CSVBuilderException;
	public List<E> getCSVFileList(Reader reader, Class<E> csvClass,char delimiter) throws CSVBuilderException;
}
