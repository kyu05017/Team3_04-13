package dao;

import java.util.ArrayList;

import dto.DTO_Car;

public class DAO_Car extends Dao {
	
	public static DAO_Car dao_Car = new DAO_Car();
	
	public boolean add(DTO_Car car) {
		try {
			String sql = "insert into car( c_title, c_content,c_img, c_category, c_price, c_cnumber, c_condition, c_km, c_fuel, c_mission, c_com, c_year, m_number) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, car.getC_title());
			ps.setString(2, car.getC_content());
			ps.setString(3, car.getC_img());
			ps.setInt(4, car.getC_category());
			ps.setInt(5, car.getC_price());
			ps.setString(6, car.getC_cnumber());
			ps.setInt(7, car.getC_condition());
			ps.setInt(8, car.getC_km());
			ps.setInt(9, car.getC_fuel());
			ps.setInt(10, car.getC_mission());
			ps.setString(11, car.getC_com());
			ps.setString(12, car.getC_year());
			ps.setInt(13, car.getM_number());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("등록 오류 "+ e);
		}
		return false;
	}
	//제품출력
		public ArrayList<DTO_Car> list(String c_title, String search) {
			ArrayList<DTO_Car> carlist = new ArrayList<>();
			try {
				String sql = null;
				if(c_title == null) {
					if(search == null) {
						sql = "select * from product car";	
						ps = con.prepareStatement(sql);
					}
					else {
						sql = "select * from car where c_name like '%"+search+"%' ";	
						ps = con.prepareStatement(sql); 
					}
				}
				else  {
					if(search ==  null) {
						sql = "select * from car where c_category = ? ";	
						ps = con.prepareStatement(sql);
						ps.setString(1, c_title);
					}
					else {
						sql = "select * from car where c_category = ? and c_name like '%"+search+"%' ";	
						ps = con.prepareStatement(sql);
						ps.setString(1, c_title);
					}
				}
				rs = ps.executeQuery();					
				while( rs.next() ) {	
					System.out.println("중고차 ");
					DTO_Car car = new DTO_Car(  
							rs.getInt(1) ,
							rs.getString(2),
							rs.getString(3), 
							rs.getString(4), 
							rs.getString(5),
							rs.getInt(6),
							rs.getInt(7),
							rs.getString(8),
							rs.getInt(9),
							rs.getInt(10),
							rs.getInt(11),
							rs.getInt(12),
							rs.getInt(13),
							rs.getString(14),
							rs.getString(15),
							rs.getInt(16)
							);
					carlist.add(car);			
				}	
				return carlist;						
			} catch (Exception e) {
				System.out.println("sql 오류 " + e);
			}
			return null;
		}
}
