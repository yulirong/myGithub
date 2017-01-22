/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 搜索核心代码
 * @author 徐建军
 * @date 2013-8-15
 * @version 1.0
 */
package com.icinfo.creditinfo.lucence.core;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.LogByteSizeMergePolicy;
import org.apache.lucene.index.LogMergePolicy;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.icinfo.creditinfo.lucence.common.LuceneConstants;


/**
 * 描述: 搜索核心代码
 * 
 * @author 徐建军
 * @date 2013-8-15
 */
public class SearchEngineCore {

	/**
	 * 描述: 打开索引
	 * 
	 * @author 徐建军
	 * @date 2013-9-4
	 * @param indexPath 索引地址
	 * @return Directory
	 * @throws IOException
	 */
	public static Directory getDirectory(String indexPath) throws IOException {
		Directory directory = null;
		String separator = File.separator;
		// 打开索引文件
		File indexDir = new File(indexPath);
		if (!indexDir.exists()) {
			indexDir.mkdirs();
		}

		directory = FSDirectory.open(indexDir);
		return directory;
	}

	/**
	 * 描述: 获取IndexWriter对象
	 * 
	 * @author 徐建军
	 * @date 2013-8-14
	 * @param indexPath 索引目录
	 * @return IndexWriter
	 * @throws IOException
	 */
	public static IndexWriter getIndexWriter(Directory directory)
			throws IOException {
		// 创建索引配置器
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
				LuceneConstants.LUCENE_VERSION, LuceneConstants.ANALYZER);
		// 创建批量索引导入策略，类似数据库分批事务
		LogMergePolicy mergePolicy = new LogByteSizeMergePolicy();
		// 设置segment添加文档(Document)时的合并频率
		// 值较小,建立索引的速度就较慢
		// 值较大,建立索引的速度就较快,>10适合批量建立索引
		mergePolicy.setMergeFactor(50);
		// 设置segment最大合并文档(Document)数
		// 值较小有利于追加索引的速度
		// 值较大,适合批量建立索引和更快的搜索
		mergePolicy.setMaxMergeDocs(Integer.MAX_VALUE);
		// true:启用复合式索引文件格式,合并多个segment
		// false:分布式索引
		// mergePolicy.setUseCompoundFile(false);
		indexWriterConfig.setMergePolicy(mergePolicy);
		// 设置写入一个新的segment前内存中保存的document的数目
		// 设置较大的数目可以加快建索引速度，默认为10
		// indexWriterConfig.setMaxBufferedDocs(100);
		indexWriterConfig.setRAMBufferSizeMB(256);
		// 设置索引的打开模式
		indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
		// 如果索引文件被锁，解锁索引文件
		if (IndexWriter.isLocked(directory)) {
			IndexWriter.unlock(directory);
		}

		// 创建索引器
		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
		// 最开始创建索引时必须先提交，不然引起读取方法报错
		indexWriter.commit();
		return indexWriter;
	}
	
	/** 
	 * 描述: 获取IndexReader对象
	 * @author 徐建军
	 * @date 2013-9-12 
	 * @param directory
	 * @return IndexReader
	 * @throws IOException 
	 */
	public static IndexReader getIndexReader(Directory directory)
			throws IOException {
		IndexReader indexReader = DirectoryReader.open(directory);
		return indexReader;
	}

	/**
	 * 描述: 提交索引
	 * 
	 * @author 徐建军
	 * @date 2013-8-15
	 * @param indexWriter
	 * @throws IOException
	 */
	public static void commitIndex(IndexWriter indexWriter) throws IOException {
		indexWriter.commit();
	}

	/**
	 * 描述: 合并索引
	 * 
	 * @author 徐建军
	 * @date 2013-8-15
	 * @param indexWriter
	 * @throws IOException
	 */
	public static void forceMerge(IndexWriter indexWriter) throws IOException {
		indexWriter.forceMerge(3);
	}

	/**
	 * 描述: 关闭索引
	 * 
	 * @author 徐建军
	 * @date 2013-8-15
	 * @param indexWriter
	 * @throws IOException
	 */
	public static void closeIndexWriter(IndexWriter indexWriter)
			throws IOException {
		if (indexWriter != null) {
			indexWriter.close();
		}
	}

	/**
	 * 描述: 获取IndexSearcher对象
	 * 
	 * @author 徐建军
	 * @date 2013-8-14
	 * @param indexWriter
	 * @return IndexSearcher
	 * @throws IOException
	 */
	public static IndexSearcher getIndexSearcher(IndexWriter indexWriter)
			throws IOException {
		IndexSearcher indexSearcher = new IndexSearcher(DirectoryReader.open(
				indexWriter, true));
		return indexSearcher;
	}

}
