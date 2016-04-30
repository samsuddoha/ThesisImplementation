package criteriaMatching;

import java.io.File;

import structureMatching.MatrixMatch;
import structureMatching.StructuralMetric;
import classDiagramSim.ClassDiagram;
import classDiagramSim.ClassDiagramAnalyzer;

public class MainClassD {

	public static void main(String[] args) {
		ClassDiagramAnalyzer analyzer=new ClassDiagramAnalyzer();
		ClassDiagram classDiagram1=analyzer.generateClassDiagram(new File("D:\\MSRESEARCH SAMSS\\Dropbox"
				+ "\\MS RESEACH\\Thesis\\Diagram\\Diagram Background\\test\\test1.xml"));
		
		ClassDiagram classDiagram2=analyzer.generateClassDiagram(new File("D:\\MSRESEARCH SAMSS\\Dropbox"
				+ "\\MS RESEACH\\Thesis\\Diagram\\Diagram Background\\test\\test2.xml"));
		
		StructuralMetric structuralMetric1=new StructuralMetric(classDiagram1);
		StructuralMetric structuralMetric2=new StructuralMetric(classDiagram2);
		
		int[][] mat1=structuralMetric1.generateStructuralMetric();
		structuralMetric1.print();
		
		int[][] mat2=structuralMetric2.generateStructuralMetric();
		structuralMetric2.print();
		MatrixMatch match=new MatrixMatch();
		System.out.println(match.naiveMatch(mat1, mat2));
	}
}
