package com.Zoko061602.ThaumicRestoration.blocks;

import com.Zoko061602.ThaumicRestoration.tile.TileMagicWall;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPavingAer extends BlockBase implements ITileEntityProvider {

    public static final PropertyBool collision = PropertyBool.create("collision");

    public BlockPavingAer() {
        super(Material.ROCK, "pickaxe", 0, 2F, 2F, "block_paving_aer");
        this.setDefaultState(this.blockState.getBaseState().withProperty(collision, true));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, collision);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        if(state.getValue(collision).booleanValue())
            return 1;
        else
            return 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        if(meta == 0)
            return this.blockState.getBaseState();
        else
            return this.blockState.getBaseState().withProperty(collision, false);
    }

    public boolean isFullCube(IBlockState state) {
        return state.getValue(collision).booleanValue();
    }

    public boolean isOpaqueCube(IBlockState state) {
        return state.getValue(collision).booleanValue();
    }

    @Override
    public boolean causesSuffocation(IBlockState state) {
        return state.getValue(collision).booleanValue();
    }

    @Override
    public Boolean isEntityInsideMaterial(IBlockAccess world, BlockPos blockpos, IBlockState state, Entity entity, double yToTest, Material materialIn, boolean testingHead) {
        return state.getValue(collision).booleanValue();
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if (state.getValue(collision).booleanValue())
            return FULL_BLOCK_AABB;
        else
            return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileMagicWall();
    }

}
