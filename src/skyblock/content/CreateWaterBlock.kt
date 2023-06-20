package skyblock.content

import mindustry.content.Items
import mindustry.type.Category
import mindustry.type.ItemStack
import mindustry.world.Block
import skyblock.world.CreateWater

class CreateWaterBlock {
	companion object {
        lateinit var createWater: Block

        fun load() {
            createWater = CreateWater("create-water").apply {
                requirements(Category.effect, ItemStack.with(Items.lead, 8, Items.silicon, 4))
                alwaysUnlocked = true
		buildCostMultiplier = 3.1f
            }
        }
    }
}
