package com.hidocmatn.timelessjs.custom.animation.part.types;

import com.hidocmatn.timelessjs.custom.animation.part.FunctionalAnimationRenderPart;

public class AnimationPartBody extends FunctionalAnimationRenderPart {
    //TODO: optimize these dirty codes
    public boolean changeHandguard;
    public String handguardModelName;
    public String changedHandguardModelName;
    public boolean changeSightModel;
    public String sightModelName;
    public String changedSightModelName;
    public boolean changeStockModel;
    public String stockModelName;
    public String changedStockModelName;
    public boolean renderStockAttachment;
    public String lightStockModelName;
    public String tacticalStockModelName;
    public String weightedStockModelName;
    public boolean renderUnderBarrelAttachment;
    public String lightGripModelName;
    public String specializedGripModelName;
    public boolean renderBarrelAttachment;
    public String silencerModelName;
    public String muzzleCompensatorModelName;
    public String muzzleBrakeModelName;
    public String defaultBarrelModelName;
    public boolean renderSideRailAttachment;
    public String basicLaserDeviceModelName;
    public String basicLaserBeamModelName;
    public boolean renderIRDeviceAttachment;
    public String IRLaserDeviceModelName;
    public String IRLaserBeamModelName;

    public AnimationPartBody(String name, int index) {
        super(name, index);
    }
    //whether handguard model should be changed when under barrel or laser attachments are installed
    public AnimationPartBody canChangeHandGuard(boolean flag) {
        this.changeHandguard = flag;
        if (flag) {
            this.handguardModelName = this.gunID + "_standard_handguard";
            this.changedHandguardModelName = this.gunID + "_extended_handguard";
        }
        return this;
    }
    public AnimationPartBody setHandguardModel(String modelName) {
        this.handguardModelName = modelName;
        return this;
    }
    public AnimationPartBody setChangedHandguardModel(String modelName) {
        this.changedHandguardModelName = modelName;
        return this;
    }

    //whether sight model should be changed when scope is installed
    public AnimationPartBody canChangeSightModel(boolean flag) {
        this.changeSightModel = flag;
        if (flag) {
            this.sightModelName = this.gunID + "_sight";
            this.changedSightModelName = this.gunID + "_folded_sight";
        }
        return this;
    }
    public AnimationPartBody setSightModel(String modelName) {
        this.sightModelName = modelName;
        return this;
    }
    public AnimationPartBody setChangedSightModel(String modelName) {
        this.changedSightModelName = modelName;
        return this;
    }

    //whether stock model should be changed when scope is installed
    public AnimationPartBody canChangeStockModel(boolean flag) {
        this.changeStockModel = flag;
        if (flag) {
            this.stockModelName = this.gunID + "_folded_stock";
            this.changedStockModelName = this.gunID + "_stock";
        }
        return this;
    }
    public AnimationPartBody setStockModel(String modelName) {
        this.stockModelName = modelName;
        return this;
    }
    public AnimationPartBody setChangedStockModel(String modelName) {
        this.changedStockModelName = modelName;
        return this;
    }

    //whether these attachments should be rendered
    //whether stock should be rendered
    public AnimationPartBody renderStockAttachment(boolean flag) {
        this.renderStockAttachment = flag;
        if (flag) {
            this.lightStockModelName = this.gunID + "_light_stock";
            this.tacticalStockModelName = this.gunID + "_tactical_stock";
            this.weightedStockModelName = this.gunID + "_weighted_stock";
        }
        return this;
    }
    public AnimationPartBody setLightStockModel(String modelName) {
        this.lightStockModelName = modelName;
        return this;
    }
    public AnimationPartBody setTacticalStockModel(String modelName) {
        this.tacticalStockModelName = modelName;
        return this;
    }
    public AnimationPartBody setWeightedStockModel(String modelName) {
        this.weightedStockModelName = modelName;
        return this;
    }
    //whether under barrel attachments should be rendered
    public AnimationPartBody renderUnderBarrelAttachment(boolean flag) {
        this.renderUnderBarrelAttachment = flag;
        if (flag) {
            this.lightGripModelName = this.gunID + "_light_grip";
            this.specializedGripModelName = this.gunID + "_specialized_grip";
        }
        return this;
    }
    public AnimationPartBody setLightGripModel(String modelName) {
        this.lightGripModelName = modelName;
        return this;
    }
    public AnimationPartBody setSpecializedGripModel(String modelName) {
        this.specializedGripModelName = modelName;
        return this;
    }
    //whether barrel attachments should be rendered
    public AnimationPartBody renderBarrelAttachment(boolean flag) {
        this.renderBarrelAttachment = flag;
        if (flag) {
            this.silencerModelName = this.gunID + "_silencer";
            this.muzzleCompensatorModelName = this.gunID + "_muzzle_compensator";
            this.muzzleBrakeModelName = this.gunID + "_muzzle_brake";
            this.defaultBarrelModelName = this.gunID + "_default_barrel";
        }
        return this;
    }
    public AnimationPartBody setSilencerModel(String modelName) {
        this.silencerModelName = modelName;
        return this;
    }
    public AnimationPartBody setMuzzleCompensatorStockModel(String modelName) {
        this.muzzleCompensatorModelName = modelName;
        return this;
    }
    public AnimationPartBody setMuzzleBrakeModel(String modelName) {
        this.muzzleBrakeModelName = modelName;
        return this;
    }
    public AnimationPartBody setDefaultBarrelModel(String modelName) {
        this.defaultBarrelModelName = modelName;
        return this;
    }
    //whether side rail attachment should be rendered
    public AnimationPartBody renderSideRailAttachment(boolean flag) {
        this.renderSideRailAttachment = flag;
        if (flag) {
            this.basicLaserDeviceModelName = this.gunID + "_basic_laser_device";
            this.basicLaserBeamModelName = this.gunID + "_basic_laser_beam";
        }
        return this;
    }
    public AnimationPartBody setBasicLaserDeviceModel(String modelName) {
        this.basicLaserDeviceModelName = modelName;
        return this;
    }
    public AnimationPartBody setBasicLaserBeamModel(String modelName) {
        this.basicLaserBeamModelName = modelName;
        return this;
    }
    //whether ir device attachment should be rendered
    public AnimationPartBody renderIRDeviceAttachment(boolean flag) {
        this.renderIRDeviceAttachment = flag;
        if (flag) {
            this.IRLaserDeviceModelName = this.gunID + "_ir_laser_device";
            this.IRLaserBeamModelName = this.gunID + "_ir_laser_beam";
        }
        return this;
    }
    public AnimationPartBody setIRLaserDeviceModel(String modelName) {
        this.IRLaserDeviceModelName = modelName;
        return this;
    }
    public AnimationPartBody setIRLaserBeamModel(String modelName) {
        this.IRLaserBeamModelName = modelName;
        return this;
    }
}
