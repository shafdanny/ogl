package fr.unice.polytech.ogl.championships.library
import eu.ace_design.island.dsl.DiSLand
import eu.ace_design.island.map.IslandMap
import eu.ace_design.island.map.processes.AssignPitch
import eu.ace_design.island.stdlib.WhittakerDiagrams
object Islands extends DiSLand {
/**
* Week 10: A single donuts, with a lot of resources available on top of it.
*/
val seed10 = 0x762FFC83BEF34278L
lazy val week10: IslandMap = {
createIsland shapedAs donut(80.percent, 20.percent) withSize 1000 having 1200.faces usingSeed seed10 builtWith Seq(
plateau(23), flowing(rivers = 15, distance = 0.2), withMoisture(soils.wet, distance = 400),
AssignPitch, usingBiomes(WhittakerDiagrams.caribbean))
}
/**
* Week 10: Still a donuts, with more rivers and higher elevation.
*/
val seed11 = 0x762FFC83BEF34978L
lazy val week11: IslandMap = {
createIsland shapedAs donut(70.percent, 10.percent) withSize 1000 having 1200.faces usingSeed seed11 builtWith Seq(
plateau(30), flowing(rivers = 30, distance = 0.2), withMoisture(soils.wet, distance = 200),
AssignPitch, usingBiomes(WhittakerDiagrams.caribbean))
}
}
