package graph;

import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public interface Node<N extends Node<N, E>, E extends Edge<N, E>> {
	/**
	 * Get nodes that this node has edges to.
	 * 
	 * @return The nodes.
	 */
	List<N> getNeighbors();

	/**
	 * Get the edges from this node to another node.
	 * 
	 * @return The edges from this node.
	 */
	List<E> getEdges();
}
