package seadustry.content

import mindustry.content.Items
import mindustry.type.Category
import mindustry.type.ItemStack
import mindustry.world.Block
import seadustry.world.CreateWater

class CreateWaterBlock {
	companion object {
        lateinit var createWater: Block

        fun load() {
            createWater = CreateWater("createWater").apply {
                requirements(Category.effect, ItemStack.with(Items.sand, 0))
                alwaysUnlocked = true
            }
        }
    }
}