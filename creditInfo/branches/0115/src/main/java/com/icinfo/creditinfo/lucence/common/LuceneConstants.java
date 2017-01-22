package com.icinfo.creditinfo.lucence.common;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;




public class LuceneConstants {
	// Lucene_分词器
	public final static Analyzer ANALYZER = new IKAnalyzer();
	
	// Lucene_版本
	public static final Version LUCENE_VERSION = Version.LUCENE_44;
}
