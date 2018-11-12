package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.alibaba.fastjson.JSON;
import com.entity.Emp;
import com.entity.Searcher;
import com.service.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	@Autowired
	private EmpService empService;

	@RequestMapping("/selectAll")
	public String selectAll(HttpSession session){
		List<Emp> findAll = empService.findAll();
		session.setAttribute("findAll", findAll);
		return "redirect:/emp.jsp";

	}

//	@RequestMapping("/selectAll2")
//	public String selectAll2(HttpSession session){	
//		File f=new File("D:\\WORK\\MyTest\\idxdir");
//		if (!f.exists()) {
//			try {
//				List<Emp> findAll = empService.findAll();
//				// 指定创建索引的时候使用的分词器 analyzer
//				Analyzer analyzer=new IKAnalyzer(); 
//				IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_35, analyzer);
//				// 指定索引库目录
//				FSDirectory open = FSDirectory.open(f);
//				IndexWriter indexWriter=new IndexWriter(open, indexWriterConfig);
//				for (Emp emp : findAll) {
//					Document document=new Document();
//					document.add(new Field("id", emp.getId()+"",Store.YES,Index.NO));
//					document.add(new Field("name",emp.getName(),Store.YES,Index.ANALYZED));
//					document.add(new Field("dept",emp.getDept(),Store.YES,Index.ANALYZED));
//					document.add(new Field("message",emp.getMessage(),Store.YES,Index.ANALYZED));
//					indexWriter.addDocument(document);
//				}
//				indexWriter.commit();
//				indexWriter.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} 		
//		return "redirect:selectAll";
//	}
//	
//	@RequestMapping("/search")
//	public String search(String text,HttpSession session){
//		if (text==null || text.length()==0) {
//			return "redirect:selectAll";
//		} else {
//			try {
//				// 指定索引库目录
//				FSDirectory open = FSDirectory.open(new File("D:\\WORK\\MyTest\\idxdir"));
//				IndexReader reader = IndexReader.open(open);
//				IndexSearcher searcher=new IndexSearcher(reader);
//				// 指定创建索引的时候使用的分词器 analyzer
//				Analyzer analyzer=new IKAnalyzer(); 
//				MultiFieldQueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_35, new String[]{"message"}, analyzer);
//				Query query = queryParser.parse(text);
//				
//				//高亮
//				SimpleHTMLFormatter formatter = new SimpleHTMLFormatter("<span style='color:red'>","</span>");
//				QueryScorer scorer = new QueryScorer(query);
//				//高亮分析器
//				Highlighter highlighter = new Highlighter(formatter, scorer);
//				
//				TopDocs topDocs = searcher.search(query, 100);
//				ScoreDoc[] scoreDocs=topDocs.scoreDocs;
//				List<Searcher> searchers=new ArrayList<Searcher>(); 
//				for (ScoreDoc scoreDoc : scoreDocs) {
//					//float score=scoreDoc.score;// 文档得分
//					int doc=scoreDoc.doc;
//					Document doc2 = searcher.doc(doc);
//					String id=doc2.get("id");
//					/*String name=highlighter.getBestFragment(analyzer, "name", doc2.get("name"));*/
//					String name=doc2.get("name");
//					String dept=doc2.get("dept");
//					/*String message=doc2.get("message");*/
//					String message=highlighter.getBestFragment(analyzer, "message", doc2.get("message"));
//					searchers.add(new Searcher(id,name,dept,message));
//				}
//				System.out.println(searchers);
//				session.setAttribute("findAll", searchers);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return "redirect:/emp.jsp";
//		}
//	}
//
//	@RequestMapping("/find")
//	@ResponseBody
//	private List<String> getJSONString(String text){
//	
//		List<String> names=new ArrayList<String>();
//		try {
//			// 指定索引库目录
//			FSDirectory open = FSDirectory.open(new File("D:\\WORK\\MyTest\\idxdir"));
//			IndexReader reader = IndexReader.open(open);
//			IndexSearcher searcher=new IndexSearcher(reader);
//			// 指定创建索引的时候使用的分词器 analyzer
//			Analyzer analyzer=new IKAnalyzer(); 
//			MultiFieldQueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_35, new String[]{"name"}, analyzer);
//			Query query = queryParser.parse(text);
//			TopDocs topDocs = searcher.search(query, 100);
//			ScoreDoc[] scoreDocs=topDocs.scoreDocs;
//			for (ScoreDoc scoreDoc : scoreDocs) {
//				//float score=scoreDoc.score;// 文档得分
//				int doc=scoreDoc.doc;
//				Document doc2 = searcher.doc(doc);
//				names.add(doc2.get("name"));
//			}
//			System.out.println(names);	
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		  return names;
//				
//	}
}

