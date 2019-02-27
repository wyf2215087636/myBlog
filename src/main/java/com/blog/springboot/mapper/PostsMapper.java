package com.blog.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.blog.springboot.pojo.Admin;
import com.blog.springboot.pojo.NewReply;
import com.blog.springboot.pojo.Posts;
import com.blog.springboot.pojo.Reply;
import com.blog.springboot.pojo.SoCode;
import com.blog.springboot.pojo.User;

@Mapper
public interface PostsMapper {
	@Select("select * from posts")
	List<Posts> findAll();

	@Insert("insert into posts(title,content,time,user_id,simple) values(#{title},#{content},#{time},1,#{simple})")
	public int save(Posts posts);

	@Delete("delete from posts where id=#{id}")
	public int delete(int id);

	@Update("update posts set title=#{title},content=#{content} where id=#{id}")
	public int update(Posts posts);

	@Update("update posts set popularity=#{popularity} where id=#{id}")
	public int updateWithPopularity(Posts posts);

	@Select("select * from user_ where id=#{user_id}")
	public User get_user(int user_id);

	@Select("select * from reply where posts_id=#{posts_id}")
	public Reply get_reply(int posts_id);

	@Select("select * from reply_ where posts_id=#{posts_id}")
	public List<NewReply> get_newReply(int posts_id);

	// insert into reply_ VALUES(null,'≤‚ ‘','≤‚ ‘','≤‚ ‘','1999-10-1 14:55:44',1)
	@Insert("insert into reply_ values(null,#{username},#{useremail},#{reply_info},#{time},#{posts_id})")
	public int save_comment(NewReply newReply);

	@Insert("insert into so_code values(#{usermail},#{code},#{time})")
	public int save_code(SoCode soCode);

	@Select("select * from so_code where code=#{mail_yzm}")
	public SoCode get_code(String mail_yzm);

	@Delete("delete from so_code where code=#{mail_yzm}")
	public int delete_code(String mail_yzm);

	@Select("select * from so_code where usermail=#{useremail}")
	public SoCode selectSoCode(String useremail);

	@Update("update so_code set code=#{code},time=#{time} where usermail=#{usermail}")
	public int updateSoCode(SoCode soCode);
	
	@Select("select * from admin where adminname=#{adminname}")
	public Admin getOneAdmin(Admin admin);
	
	@Update("update admin set login_time=#{login_time} where adminname=#{adminname}")
	public int updateAdmin(Admin admin);
	
	Posts getPosts(int id);

	List<Posts> getAllPosts();

	int insertUser(User user);

	int insertPosts(Posts posts);

	int insertReply(Reply reply);
}
