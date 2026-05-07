package de.phbe

import de.phbe.solid.OpenClosedPrincipleOCP
import de.phbe.solid.SingleResponsibilitySRP

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // SRP
    val singleResponsibility = SingleResponsibilitySRP()
    singleResponsibility.showPrinciple()

    // OCP
    val openClosedPrincipleOCP = OpenClosedPrincipleOCP()
    openClosedPrincipleOCP.showPrinciple()

}