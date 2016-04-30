package structureMatching;

import java.io.File;

import classDiagramSim.ClassDiagram;
import classDiagramSim.ClassDiagramAnalyzer;

public class MainSequenceD {

	public static void main(String[] args) {
		ClassDiagramAnalyzer analyzer=new ClassDiagramAnalyzer();
		ClassDiagram classDiagram=analyzer.generateClassDiagram(new File("D:\\MSRESEARCH SAMSS\\Dropbox"
				+ "\\MS RESEACH\\Thesis\\Diagram\\Diagram Background\\test\\test.xml"));
		StructuralMetric structuralMetric=new StructuralMetric(classDiagram);
		int[][] mat1=structuralMetric.generateStructuralMetric();
		structuralMetric.print();
		MatrixMatch match=new MatrixMatch();
		System.out.println(match.naiveMatch(mat1, mat1));
	}
}
