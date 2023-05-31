package seadustry

import mindustry.mod.Mod
import seadustry.content.CreateLandBlock
import seadustry.content.CreateWaterBlock

class Seadustry : Mod() {

    override fun loadContent() {
        CreateWaterBlock.load()
		CreateLandBlock.load()
    }
}
