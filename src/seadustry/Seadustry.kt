package seadustry

import mindustry.mod.Mod
import seadustry.content.CreateLandBlock
import seadustry.content.CreateWaterBlock
import seadustry.content.CreateCoreZoneBlock
import seadustry.content.EnableShardCore

class Seadustry : Mod() {

    override fun loadContent() {
        CreateWaterBlock.load()
	CreateLandBlock.load()
	CreateCoreZoneBlock.load()
	EnableShardCore.load()
    }
}
