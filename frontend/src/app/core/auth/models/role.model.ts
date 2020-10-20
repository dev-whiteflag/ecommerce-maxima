import {PermissionModel} from './permission.model';

export interface RoleModel {
  name: string;
  description: string;
  permissions: PermissionModel[];
}
