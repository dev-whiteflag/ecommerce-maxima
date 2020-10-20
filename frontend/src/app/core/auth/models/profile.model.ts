import {RoleModel} from './role.model';

export interface ProfileModel {
  name: string;
  roles: RoleModel[];
}
